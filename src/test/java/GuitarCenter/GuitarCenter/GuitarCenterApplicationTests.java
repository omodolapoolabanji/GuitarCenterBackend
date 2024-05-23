package GuitarCenter.GuitarCenter;

import GuitarCenter.GuitarCenter.model.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GuitarCenterApplicationTests {


	@Test
	void seedRepo() throws IOException {
		String jsonFile = "src/main/resources/sample.json";
		ObjectMapper om = new ObjectMapper();
		try{
			JsonNode jn = om.readTree(new File(jsonFile));

			if(jn.isObject()){
				JsonNode guitar = jn.get("guitars");
				List<Item> guitarList = new ArrayList<>();
				for(JsonNode guitars: guitar){
					String name = guitars.get("name").asText();
					String description = guitars.get("description").asText();
					int price = guitars.get("price").asInt();
					int id = guitars.get("id").asInt();
					int rate = guitars.get("rate").asInt();
					int count = guitars.get("count").asInt();
					String imageUrl= guitars.get("imageUrl").asText();
					String type = guitars.get("type").asText();
					String brand = guitars.get("brand").asText();

					guitarList.add(Guitar.Factory(name, description, price, id, rate, count, imageUrl, type, brand));
				}
				System.out.println(guitarList);
				for(Item g: guitarList){
					assertNotEquals(g, null);
				}
				JsonNode node = jn.get("amps");
				List<Item> ampsList = new ArrayList<>();
				for(JsonNode amps :node){
					String name = amps.get("name").asText();
					String description =amps.get("description").asText();
					int price = amps.get("price").asInt();
					int id =amps.get("id").asInt();
					int rate = amps.get("rate").asInt();
					int count = amps.get("count").asInt();
					String imageUrl = amps.get("imageUrl").asText();
					String category = amps.get("category").asText();
					Item amp = new Amps(name, description, price, rate, count, imageUrl);
					System.out.println(amp);
					ampsList.add(amp);
				}
				assertNotNull(ampsList );
				JsonNode acc = jn.get("accessories");
				List<Item> accessories = new ArrayList<>();
				for(JsonNode a : acc){
					String name  = a.get("name").asText();
					String description = a.get("description").asText();
					int price = a.get("price").asInt();
					int rate = a.get("rate").asInt();
					int count = a.get("count").asInt();
					String imageUrl = a.get("imageUrl").asText();
					String category = a.get("category").asText();
					String type = a.get("type").asText();
					GuitarType tn = GuitarType.getType(type);
					Item accessory = new Accessories(name, description, price, rate, count, imageUrl,  tn);

					accessories.add(accessory);
				}

			}else{
				throw new InvalidObjectException("Needs to parse an array");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
