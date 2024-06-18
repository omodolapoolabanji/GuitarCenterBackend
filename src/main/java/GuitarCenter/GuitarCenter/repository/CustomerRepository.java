package GuitarCenter.GuitarCenter.repository;

import GuitarCenter.GuitarCenter.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findCustomerById(Long id);
    List<Customer> findAll();
    Boolean existsByEmail(String customer);
    Customer findCustomerByEmail(String email);

    Customer findByEmail(String email);
}
