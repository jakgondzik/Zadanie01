package car.repository.jpa;

import car.model.Brand;
import car.model.Car;
import car.model.Dealership;
import car.repository.CarDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class JpaCarDao  implements CarDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Car> findAll(){
        return entityManager.createQuery("select c from Car c").getResultList();
    }
    @Override
    public Car findById(int id) {
        return entityManager.find(Car.class, id);
    }
    @Override
    public List<Car> findByBrand(Brand b) {
        return entityManager
                .createQuery("select c from Car c where c.brand =: brand")
                .setParameter("brand", b)
                .getResultList();
    }
        @Override
        public List<Car> findByDealership(Dealership d) {
            return entityManager.createQuery(
                    "select c from Car c inner join c.dealerships dealership where dealership=:dealership")
                    .setParameter("dealership", d)
                    .getResultList();

    }
    @Override
    public Car addCar(Car c){
        entityManager.persist(c);
        return c;
    }
}


