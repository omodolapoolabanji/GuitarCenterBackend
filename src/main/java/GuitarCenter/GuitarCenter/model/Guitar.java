package GuitarCenter.GuitarCenter.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("GUITAR")
public abstract class Guitar extends Item {
    public GuitarType type;
    public Brand  brand;

    public Guitar(String name, String description, int price, int rate, int count, String imageUrl, GuitarType type,Brand brand){

        super(name, description, price,  rate, count, imageUrl,"Guitar" );
        this.type = type;
        this.brand = brand;
    }


    public Guitar() {

    }

    public static Item Factory(String name, String description, int price, int id, int rate, int count, String imageUrl, String type,String brand){
        brand = brand.strip();
        brand = brand.toUpperCase();
        Brand newBrand = Brand.getType(brand);
         switch(GuitarType.getType(type)){
             case ACOUSTIC -> {
                 return new AcousticGuitar(name, description, price, rate, count, imageUrl, newBrand);
             }

             case ELECTRIC -> {
                 return new ElectricGuitar(name, description, price,  rate, count, imageUrl, newBrand);
             }
             case CLASSICAL -> {
                 return new ClassicalGuitar(name, description, price, rate, count, imageUrl, newBrand);
             }
             case null, default -> {
                 return null;
             }

         }
    }
}
