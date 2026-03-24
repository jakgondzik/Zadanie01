package car.repository.data;

import car.model.Brand;
import car.model.Car;
import car.model.Dealership;
import car.repository.CarDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@RequiredArgsConstructor
@Primary
public class DataCarDao implements CarDao {
    private final CarRepository repository;

    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }
    @Override
    public Car findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Car> findByBrand(Brand brand) {
        return repository.findAllByBrand(brand);
    }

    @Override
    public List<Car> findByDealership(Dealership dealership) {
        return repository.findAllByDealershipsContaining(dealership);
    }
    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Car addCar(Car car) {
        return repository.save(car);
    }

}
