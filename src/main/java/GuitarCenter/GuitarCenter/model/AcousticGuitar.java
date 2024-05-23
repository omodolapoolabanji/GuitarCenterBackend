package GuitarCenter.GuitarCenter.model;

import jakarta.persistence.Entity;

@Entity
public class AcousticGuitar extends Guitar{

    public AcousticGuitar(String name, String description, int price, int rate, int count, String imageUrl, Brand brand){
        super(name, description, price, rate, count, imageUrl, GuitarType.ACOUSTIC, brand);

    }

    public AcousticGuitar() {

    }
}
