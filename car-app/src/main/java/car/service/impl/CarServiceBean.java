package car.service.impl;

import car.model.Brand;
import car.model.Car;
import car.model.Dealership;
import car.repository.BrandDao;
import car.repository.CarDao;
import car.repository.DealershipDao;
import car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
@Service
public class CarServiceBean implements CarService {
    private static final Logger log = Logger.getLogger(CarService.class.getName());

    private BrandDao brandDao;
    private CarDao carDao;
    @Autowired
    public void setBrandDao(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    private DealershipDao dealershipDao;

    public CarServiceBean(BrandDao brandDao, CarDao carDao, DealershipDao dealershipDao) {
        this.brandDao = brandDao;
        this.carDao = carDao;
        this.dealershipDao = dealershipDao;
        log.info("creating car service bean");
    }
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

    @Override
    public Car addCar(Car c) {
        log.info("Add car");
        return carDao.add(c);
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
