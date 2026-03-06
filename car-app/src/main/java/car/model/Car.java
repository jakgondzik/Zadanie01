package car.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int id;
    private String model;
    private Brand brand;
    private float price;
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
