package GuitarCenter.GuitarCenter.repository;

import GuitarCenter.GuitarCenter.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findCustomerById(Integer id);
    List<Customer> findAll();

    Customer findByEmail(String email);
}
