package GuitarCenter.GuitarCenter.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AMPS")
public class Amps extends Item{

    public Amps(String name, String description, int price,  int rate, int count, String imageUrl) {
        super(name, description, price, rate, count, imageUrl, "Amps");
    }

    public Amps() {


    }
}
