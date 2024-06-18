package GuitarCenter.GuitarCenter.model;
import java.util.List;

import ch.qos.logback.classic.net.SMTPAppender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(schema = "guitars")
@DiscriminatorColumn(name = "item_type", discriminatorType = DiscriminatorType.STRING)
public  class Item {
    String name;
    String description;
    String imageUrl;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int price;



    int rate;
    int count;
    String category;

    public Item(){}
    public Item(String name, String description, int price, int rate, int count, String imageUrl, String category){
        this.description = description;
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;

        this.category = category;
        this.rate = rate;
        this.count = count;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
