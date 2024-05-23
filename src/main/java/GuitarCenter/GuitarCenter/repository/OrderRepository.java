package GuitarCenter.GuitarCenter.repository;

import GuitarCenter.GuitarCenter.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer>{
    List<Order> findByCustomerId(int customerId );


}
