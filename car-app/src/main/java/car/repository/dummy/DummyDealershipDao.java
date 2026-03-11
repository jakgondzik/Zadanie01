package car.repository.dummy;

import car.model.Car;
import car.model.Dealership;
import car.repository.DealershipDao;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DummyDealershipDao implements DealershipDao {
    @Override
    public List<Dealership> findAll(){
        return List.of();
    }
    @Override
    public Dealership findById(int id){
        return null;
    }
    @Override
    public List<Dealership> findByCar(Car c){
        return List.of();
    }

    @Override
    public Dealership save(Dealership dealership) {
        return null;
    }
}
