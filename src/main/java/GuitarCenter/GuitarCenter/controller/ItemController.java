package GuitarCenter.GuitarCenter.controller;

import GuitarCenter.GuitarCenter.model.Item;
import GuitarCenter.GuitarCenter.repository.ItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    public ItemRepository itemRepo;

    public ItemController(ItemRepository itemRepo){
        this.itemRepo = itemRepo;
    }

    @GetMapping()
    public List<Item> getAllItems(){
        return itemRepo.findAll();
    }
    @GetMapping("/guitars")
    public List<Item> getAllGuitars(){
        return itemRepo.findItemByCategory("Guitar");
    }
    @GetMapping("/amps")
    public List<Item> getAllAmps(){
        return itemRepo.findItemByCategory("Amps");
    }

    @GetMapping("/accessories")
    public List<Item> getAllAccessories(){
        return itemRepo.findItemByCategory("");
    }
}
