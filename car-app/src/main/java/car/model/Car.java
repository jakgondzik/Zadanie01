package car.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "car")
public class Car {

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int id;
    private String model;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    private float price;
    @ManyToMany
    @JoinTable(name="car_dealership", joinColumns = @JoinColumn(name="car_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dealership_id",referencedColumnName = "id"))
    private List<Dealership> dealerships =  new ArrayList<Dealership>();
    public Car(int id, String model, Brand brand, float price) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.price = price;
    }




    public Car() {
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Brand getBrand() {
        return brand;
    }

    public float getPrice() {
        return price;
    }

    public List<Dealership> getDealerships() {
        return dealerships;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDealerships(List<Dealership> dealerships) {
        this.dealerships = dealerships;
    }
    public void addDealership(Dealership dealership) {
        dealerships.add(dealership);
    }
    @Override
    public String toString() {
        return "Car{" +
                "Brand='" + brand + '\'' +
                ", model=" + model +
                ", price=" + price +
                '}';
    }
}
