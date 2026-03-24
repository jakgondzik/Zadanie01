package car.repository.data;

import car.model.Brand;
import car.model.Car;
import car.model.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByBrand(Brand brand);

    List<Car> findAllByDealershipsContaining(Dealership dealership);
}
