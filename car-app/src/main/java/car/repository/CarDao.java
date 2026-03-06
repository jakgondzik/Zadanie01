package car.repository;

import car.model.Brand;
import car.model.Car;
import car.model.Dealership;

import java.util.List;

public interface CarDao {
    List<Car> findAll();
    Car findById(int id);
    List<Car> findByBrand(Brand brand);
    List<Car> findByDealership(Dealership dealership);
    Car add(Car car);
}
