package car.repository.data;

import car.model.Car;
import car.model.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DealershipRepository extends JpaRepository<Dealership, Integer> {
        List<Dealership> findAllByNameContaining(String name);



        @Query("select d from Dealership d inner join d.cars car where car=:car")
        List<Dealership> findAllByCar(@Param("car") Car car);
}
