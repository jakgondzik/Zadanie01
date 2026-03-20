package car.repository.jpa;

import car.repository.DealershipDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class JpaDealershipDao implements DealershipDao {
    @PersistenceContext
    private EntityManager entityManager;

}
