package GuitarCenter.GuitarCenter.model;

import jakarta.persistence.Entity;

@Entity
public class ClassicalGuitar extends Guitar{

    public ClassicalGuitar(String name, String description, int price,  int rate, int count, String imageUrl,Brand brand){
        super(name, description, price, rate, count, imageUrl, GuitarType.CLASSICAL, brand);

    }

    public ClassicalGuitar() {

    }
}
