package GuitarCenter.GuitarCenter.repository;

import GuitarCenter.GuitarCenter.model.Guitar;
import GuitarCenter.GuitarCenter.model.GuitarType;
import GuitarCenter.GuitarCenter.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuitarRepository extends CrudRepository <Guitar, Integer> {
    List<Item> getGuitarsByType(GuitarType type);
}
