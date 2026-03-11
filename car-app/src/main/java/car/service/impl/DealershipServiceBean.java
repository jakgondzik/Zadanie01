package car.service.impl;

import car.model.Car;
import car.model.Dealership;
import car.repository.CarDao;
import car.repository.DealershipDao;
import car.service.DealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
@Service
@Scope("prototype")
public class DealershipServiceBean implements DealershipService {

    private static final Logger log = Logger.getLogger(DealershipServiceBean.class.getName());

    private CarDao carDao;

    private DealershipDao dealershipDao;
    @Override
    public Dealership getDealershipById(int id) {
        log.info("Getting dealership by id: " + id);
        return dealershipDao.findById(id);
    }

    @Override
    public List<Dealership> getAllDealerships() {
        log.info("Getting all dealerships");
        return dealershipDao.findAll();
    }

    @Override
    public List<Dealership> getDealershipsByCar(Car c) {
        log.info("Getting dealerships by car: " + c);
        return dealershipDao.findByCar(c);
    }


    @Override
    public List<Car> getCarsInDealership(Dealership d) {
        log.info("Getting cars in dealership: " + d.getId());
        return carDao.findByDealership(d);
    }

    public DealershipServiceBean(CarDao carDao, DealershipDao dealershipDao) {
        this.carDao = carDao;
        this.dealershipDao = dealershipDao;
        log.info("creating dealerships service bean");
    }
    @Override
    public Dealership addDealership(Dealership dealership) {
        log.info("Adding dealership: " + dealership);
        return dealershipDao.save(dealership);
    }

}
