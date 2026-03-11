package car.repository.mem;

import car.model.Brand;
import car.model.Car;
import car.model.Dealership;
import car.repository.BrandDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component("brandDao")
public class MemBrandDao implements BrandDao {
    @Override
    public List<Brand> findAll() {return SampleData.brands;}
    @Override
    public Brand findById(int id) {
        return SampleData.brands.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }
    @Override
    public Brand add(Brand b) {
        int max = SampleData.brands.stream().max((b1, b2) -> b1.getId() - b2.getId()).get().getId();
        b.setId(++max);
        SampleData.brands.add(b);
        return b;
    }
}
