package GuitarCenter.GuitarCenter.model;

import jakarta.persistence.Entity;

@Entity
public class ElectricGuitar extends Guitar{

    public ElectricGuitar(String name, String description, int price, int rate, int count, String imageUrl,Brand brand){
        super(name, description, price, rate, count, imageUrl, GuitarType.ELECTRIC, brand);

    }

    public ElectricGuitar() {

    }
}
