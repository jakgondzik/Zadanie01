package car.service.impl;

import car.model.Brand;
import car.model.Car;
import car.model.Dealership;
import car.repository.BrandDao;
import car.repository.CarDao;
import car.repository.DealershipDao;
import car.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.logging.Logger;
@Service
@RequiredArgsConstructor
public class CarServiceBean implements CarService {
    private static final Logger log = Logger.getLogger(CarService.class.getName());

    private final BrandDao brandDao;
    private final CarDao carDao;

    private final PlatformTransactionManager transactionManager;


    private final DealershipDao dealershipDao;

   // public CarServiceBean(BrandDao brandDao, CarDao carDao, DealershipDao dealershipDao) {
     //   this.brandDao = brandDao;
      //  this.carDao = carDao;
       // this.dealershipDao = dealershipDao;
        //log.info("creating car service bean");
    //}
    public List<Car> getAllCars() {
        log.info("Get all cars");
        return carDao.findAll();
    }

    public Car getCarById(int id) {
        log.info("Get car by id");
        return carDao.findById(id);
    }
    public List<Car> getCarsByBrand(Brand brand) {
        log.info("Get cars by brand");
        return carDao.findByBrand(brand);
    }
    public List<Brand> getAllBrands() {
        log.info("Get all brands");
        return brandDao.findAll();
    }
    public Brand getBrandById(int id) {
        log.info("Get brand by id");
        return brandDao.findById(id);
    }
    //@Transactional(propagation = Propagation.REQUIRED)
    //@Override
    //public Car addCar(Car c) {
    //    log.info("Add car");
    //    carDao.addCar(c);
    //    if(c.getModel().equals("Apocalypse now")){
    //        throw new RuntimeException("not yet");
    //    }
    //    return c;
    //}

    @Override
    public Car addCar(Car car) {
        log.info("Add car" + car);
        TransactionStatus ts = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            car = carDao.addCar(car);
            if(car.getModel().equals("Apocalypse Now")){
                throw new RuntimeException("not yet! :");
            }
            transactionManager.commit(ts);
        }catch(RuntimeException e){
           transactionManager.rollback(ts);
            throw e;
        }return car;
    }

    public Brand addBrand(Brand b) {
        log.info("Add brand");
        return brandDao.add(b);
    }
    /*






    Car addCar(Car m);






    Brand addBrand(Brand b);
     */

}
