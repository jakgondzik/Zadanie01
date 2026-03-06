package car.service;


import car.model.Dealership;
import car.repository.CarDao;
import car.repository.DealershipDao;
import car.repository.mem.MemCarDao;
import car.repository.mem.MemDealershipDao;
import car.service.impl.DealershipServiceBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Lets find cars");
        ApplicationContext context = new
        AnnotationConfigApplicationContext("car");
        DealershipService service = context.getBean(DealershipService.class);
        DealershipDao dealershipDao = new MemDealershipDao();
        CarDao carDao = new MemCarDao();

       // DealershipService service = new DealershipServiceBean(carDao, dealershipDao);
/**/

        DealershipService service2 = context.getBean(DealershipService.class);
        List<Dealership> dealerships = service.getAllDealerships();

        System.out.println(dealerships.size() + " dealerships:");
        dealerships.forEach(System.out::println);

        String foo = context.getBean(String.class);
        System.out.println("Foo string"+foo);

    }
}