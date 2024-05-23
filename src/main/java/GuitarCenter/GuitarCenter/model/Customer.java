package GuitarCenter.GuitarCenter.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(schema = "guitars")
public class Customer {
    private String email;
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer(String email, String password){
            this.email = email;
            this.password = password;
    }
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


}
