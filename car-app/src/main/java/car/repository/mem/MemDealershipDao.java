package car.repository.mem;

import car.model.Car;
import car.model.Dealership;
import car.repository.DealershipDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component("dealershipDao")
//@Primary
public class MemDealershipDao implements DealershipDao {

    @Override
    public List<Dealership> findAll() {
        return SampleData.dealerships;
    }

    @Override
    public Dealership findById(int id) {
        return SampleData.dealerships.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Dealership> findByCar(Car c) {
        return SampleData.dealerships.stream().filter(d -> d.getCars().contains(c)).collect(Collectors.toList());
    }
    @Override
    public Dealership save(Dealership dealership){
        int maxId = SampleData.dealerships.stream()
                .sorted((d1,d2)-> d2.getId()-d1.getId())
                .findFirst()
                .map(d->d.getId())
                .orElse(0);
        dealership.setId(maxId+1);
        SampleData.dealerships.add(dealership);
        return dealership;
    }
}
