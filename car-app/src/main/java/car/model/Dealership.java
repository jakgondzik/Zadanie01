package car.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private int id;
    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    private String logo;
    @JsonIgnore
    private List<Car> cars = new ArrayList<>(); // wiele do wiele

    public Dealership(int id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;

    }

    public Dealership() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public void addCar(Car car) {
        this.cars.add(car);
    }
    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
