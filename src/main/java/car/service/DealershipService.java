package car.service;

import car.model.Car;
import car.model.Dealership;

import java.util.List;

public interface DealershipService {
    Dealership getDealershipById(int id);

    List<Dealership> getAllDealerships();

    List<Dealership> getDealershipsByCar(Car c);

    List<Car> getCarsInDealership(Dealership d);
}
