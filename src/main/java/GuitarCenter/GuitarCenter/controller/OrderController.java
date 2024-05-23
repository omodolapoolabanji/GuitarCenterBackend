package GuitarCenter.GuitarCenter.controller;

import GuitarCenter.GuitarCenter.model.Customer;
import GuitarCenter.GuitarCenter.model.Item;
import GuitarCenter.GuitarCenter.model.Order;
import GuitarCenter.GuitarCenter.repository.CustomerRepository;
import GuitarCenter.GuitarCenter.repository.ItemRepository;
import GuitarCenter.GuitarCenter.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private ItemRepository itemRepo;
    private OrderRepository orderRepo;
    private CustomerRepository customerRepo;

    public OrderController(ItemRepository itemRepo, OrderRepository orderRepo, CustomerRepository customerRepo){
        this.orderRepo = orderRepo;
        this.itemRepo = itemRepo;
        this.customerRepo = customerRepo;
    }
    @PostMapping
    public boolean addOrderByCustomer(@RequestBody Order order, @RequestParam int id){
        try{
            Customer customer = customerRepo.findCustomerById(id);
            order.setCustomer(customer);
            orderRepo.save(order);
            return true;

        }
        catch(Exception ex){
            throw new RuntimeException(ex);
        }


    }
    @GetMapping
    public List<Order> getOrder(@RequestParam int id){
        try{
            return orderRepo.findByCustomerId(id);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }

    }



}
