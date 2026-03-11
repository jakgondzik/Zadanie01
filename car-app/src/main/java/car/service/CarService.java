package car.service;

import car.model.Brand;
import car.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    List<Car> getCarsByBrand(Brand b);

    Car getCarById(int id);

    Car addCar(Car c);


    List<Brand> getAllBrands();

   Brand getBrandById(int id);

    Brand addBrand(Brand b);

}
