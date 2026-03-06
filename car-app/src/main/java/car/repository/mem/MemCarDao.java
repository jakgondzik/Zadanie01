package car.repository.mem;

import car.model.Brand;
import car.model.Car;
import car.model.Dealership;
import car.repository.CarDao;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;
@Component
public class MemCarDao implements CarDao {
    @Override
    public List<Car> findAll() {return SampleData.cars;}
    @Override
    public Car findById(int id) {return SampleData.cars.stream().filter(c -> c.getId() == id).findFirst().orElse(null);}
    @Override
    public List<Car> findByBrand(Brand b) {
        return SampleData.cars.stream().filter(c -> c.getBrand() == b).collect(Collectors.toList());
    }
    @Override
    public List<Car> findByDealership(Dealership d){
        return SampleData.cars.stream().filter(c -> c.getDealerships().contains(d)).collect(Collectors.toList());
    }
    @Override
    public Car add(Car c) {
        int max = SampleData.cars.stream().max((c1, c2) -> c1.getId() - c2.getId()).get().getId();
        c.setId(++max);
        SampleData.cars.add(c);
        return c;
    }
}
