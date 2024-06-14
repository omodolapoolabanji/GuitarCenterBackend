package GuitarCenter.GuitarCenter.controller;

import GuitarCenter.GuitarCenter.model.GuitarType;
import GuitarCenter.GuitarCenter.model.Item;
import GuitarCenter.GuitarCenter.repository.GuitarRepository;
import GuitarCenter.GuitarCenter.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class ItemController {

    public ItemRepository itemRepo;

    public GuitarRepository guitarRepo;

    public ItemController(ItemRepository itemRepo, GuitarRepository guitarRepo){
        this.itemRepo = itemRepo;
        this.guitarRepo = guitarRepo;
    }

    @GetMapping()
    public List<Item> getAllItems(){
        return itemRepo.findAll();
    }
    @GetMapping("/guitars")
    public List<Item> getAllGuitars(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "6") int size){
        Pageable pageWithNElements = PageRequest.of(page, size);

        return itemRepo.findItemByCategory("Guitar", pageWithNElements);
    }


    @GetMapping("guitars/{idx}")

    public List<Item> getGuitarsByType(@PathVariable String idx){
        try{
            GuitarType type = GuitarType.getType(idx);
            return guitarRepo.getGuitarsByType(type);
        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }


    @GetMapping("/amps")

    public List<Item> getAllAmps(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "6") int size){
        Pageable pageWithNElements = PageRequest.of(page, size);

        return itemRepo.findItemByCategory("Amps", pageWithNElements);
    }

    @GetMapping("/accessories")
    public List<Item> getAllAccessories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "6") int size){
        Pageable pageWithNElements = PageRequest.of(page, size);

        return itemRepo.findItemsByCategoryNot("Guitar", pageWithNElements);
    }

    @GetMapping("/popular")
    public List<Item> getPopularGuitars(){
        return new ArrayList<>();
    }

    @GetMapping("/search/{idx}")
    public List<Item> searchItems(@PathVariable String idx){
        try{
            idx = idx.substring(0, 1).toUpperCase() + idx.substring(1);
            String query = idx.length() > 5 ? idx.substring(0, 5) : idx;
            return itemRepo.findItemByNameStartingWith(query);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

    }
}
