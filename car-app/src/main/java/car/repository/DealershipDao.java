package car.repository;

import car.model.Car;
import car.model.Dealership;
import car.repository.mem.SampleData;

import java.util.List;

public interface DealershipDao {
    List<Dealership> findAll();
    Dealership findById(int id);
    List<Dealership> findByCar(Car car);
    Dealership save(Dealership dealership);
}
