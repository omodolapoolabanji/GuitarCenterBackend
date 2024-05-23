package GuitarCenter.GuitarCenter.repository;

import GuitarCenter.GuitarCenter.model.Guitar;
import GuitarCenter.GuitarCenter.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer>{

    List<Item> findAll();

    List<Item> findItemByCategory(String category);

    Item findItemByCategoryAndId(String category, Integer Id);

    Item findItemByImageUrl(String url);

}
