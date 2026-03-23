package car.repository.jpa;

import car.model.Car;
import car.model.Dealership;
import car.repository.DealershipDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
//Skasowałem dummy i wyrzucilem primary z memdealershipdao
@Repository

public class JpaDealershipDao implements DealershipDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Dealership> findAll(){
        //SQL-> HQL->JPQL
        return entityManager
                .createQuery("select d from Dealership d")
                .getResultList();
    }
    @Override
    public Dealership findById(int id) {
        return entityManager.find(Dealership.class, id);
    }
    @Override
    public List<Dealership> findByCar(Car c){
        return entityManager
                .createQuery("select d from Dealership d inner join d.cars car where car =: car")
                .setParameter("car", c)
                .getResultList();
    }
    @Override
    public Dealership save(Dealership dealership){
        entityManager.persist(dealership);
        return dealership;
    }
}
