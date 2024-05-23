package GuitarCenter.GuitarCenter.service;

import GuitarCenter.GuitarCenter.model.*;
import GuitarCenter.GuitarCenter.repository.ItemRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InitializationService {
    @Autowired
    private ItemRepository repo;
    @PostConstruct
    public void seed(){
        String jsonFile = "src/main/resources/sample.json";
        ObjectMapper om = new ObjectMapper();
        try{
            JsonNode jn = om.readTree(new File(jsonFile));

            if(jn.isObject()){
                JsonNode guitar = jn.get("guitars");
                List<Item> guitarList = new ArrayList<>();
                for(JsonNode guitars: guitar){
                    String imageUrl = guitars.get("imageUrl").asText();
                    Optional<Item> query = Optional.ofNullable(repo.findItemByImageUrl(imageUrl));
                    if(query.isEmpty()){
                    String name = guitars.get("name").asText();
                    String description = guitars.get("description").asText();
                    int price = guitars.get("price").asInt();
                    int id = guitars.get("id").asInt();
                    int rate = guitars.get("rate").asInt();
                    int count = guitars.get("count").asInt();

                    String type = guitars.get("type").asText();
                    String brand = guitars.get("brand").asText();

                    guitarList.add(Guitar.Factory(name, description, price, id, rate, count, imageUrl, type, brand));}
                }
                System.out.println(guitarList);
                repo.saveAll(guitarList);
                JsonNode node = jn.get("amps");
                List<Amps> ampsList = new ArrayList<>();
                for(JsonNode amps :node){
                    String imageUrl = amps.get("imageUrl").asText();
                    Optional<Item> query = Optional.ofNullable(repo.findItemByImageUrl(imageUrl));
                    if(query.isEmpty()){
                    String name = amps.get("name").asText();
                    String description =amps.get("description").asText();
                    int price = amps.get("price").asInt();
                    int id =amps.get("id").asInt();
                    int rate = amps.get("rate").asInt();
                    int count = amps.get("count").asInt();

                    String category = amps.get("category").asText();
                    Amps amp = new Amps(name, description, price, rate, count, imageUrl);

                    ampsList.add(amp);}
                }
                repo.saveAll(ampsList);
                JsonNode acc = jn.get("accessories");
                List<Item> accessories = new ArrayList<>();
                for(JsonNode a : acc){
                    String imageUrl = a.get("imageUrl").asText();
                    Optional<Item> query = Optional.ofNullable(repo.findItemByImageUrl(imageUrl));
                    if(query.isEmpty()){
                    String name  = a.get("name").asText();
                    String description = a.get("description").asText();
                    int price = a.get("price").asInt();
                    int rate = a.get("rate").asInt();
                    int count = a.get("count").asInt();
                    String category = a.get("category").asText();
                    String type = a.get("type").asText();
                    GuitarType tn = GuitarType.getType(type);
                    Item accessory = new Accessories(name, description, price, rate, count, imageUrl,  tn);

                    accessories.add(accessory);}
                }
                repo.saveAll(accessories);
            }else{
                throw new InvalidObjectException("Needs to parse an array");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
