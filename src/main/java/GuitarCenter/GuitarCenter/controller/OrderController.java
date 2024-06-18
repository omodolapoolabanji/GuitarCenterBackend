package GuitarCenter.GuitarCenter.controller;

import GuitarCenter.GuitarCenter.model.Customer;
import GuitarCenter.GuitarCenter.model.Item;
import GuitarCenter.GuitarCenter.model.Order;
import GuitarCenter.GuitarCenter.repository.CustomerRepository;
import GuitarCenter.GuitarCenter.repository.ItemRepository;
import GuitarCenter.GuitarCenter.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {


    private final OrderRepository orderRepo;
    private final CustomerRepository customerRepo;
    private final ItemRepository itemRepo;

    public OrderController(ItemRepository itemRepo, OrderRepository orderRepo, CustomerRepository customerRepo){
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.itemRepo = itemRepo;
    }
    @PostMapping
    public boolean addOrderByCustomer(@RequestBody Order order, @RequestParam String email){
        try{
            Customer customer = customerRepo.findCustomerByEmail(email);
            order.setCustomer(customer);
            orderRepo.save(order);
            List<Item> items = order.getItems();
            for(Item item : items){
                item.setOrder(order);
            }
            itemRepo.saveAll(items);


            return true;

        }
        catch(Exception ex){
            throw new RuntimeException(ex);
        }


    }

    @GetMapping
    public List<Order> getOrder(@RequestParam String email){

        try{
            Customer customer = customerRepo.findCustomerByEmail(email);
            return orderRepo.findByCustomerId(customer.getId());
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }

    }
    @DeleteMapping
    public Boolean deleteOrder(@RequestParam Order order){
        try{
            orderRepo.delete(order);
            return true;

        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }
    @PutMapping("/order")
    public ResponseEntity<Boolean> changeOrder(@RequestBody Order order) {
        try {
            orderRepo.save(order);
            return ResponseEntity.ok(true);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }



}
