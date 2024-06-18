package GuitarCenter.GuitarCenter.repository;

import GuitarCenter.GuitarCenter.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer>{
    List<Order> findByCustomerId(long customerId );
    List<Order> findOrderByCustomer_Email(String email);

}
