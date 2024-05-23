package GuitarCenter.GuitarCenter.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ACCESSORIES")
public class Accessories extends Item{
    public GuitarType type;
    public Accessories(String name, String description, int price, int rate, int count, String imageUrl, GuitarType type){
        super(name, description, price, rate, count, imageUrl, "Accessories");
        this.type = type;
    }

    public Accessories() {

    }
}
