package car.service;


import car.model.Dealership;
import car.repository.CarDao;
import car.repository.DealershipDao;
import car.repository.mem.MemCarDao;
import car.repository.mem.MemDealershipDao;
import car.service.impl.DealershipServiceBean;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Lets find cars");
        DealershipDao dealershipDao = new MemDealershipDao();
        CarDao carDao = new MemCarDao();

        DealershipService service = new DealershipServiceBean(carDao, dealershipDao);


        List<Dealership> dealerships = service.getAllDealerships();

        System.out.println(dealerships.size() + " dealerships:");
        dealerships.forEach(System.out::println);

    }
}