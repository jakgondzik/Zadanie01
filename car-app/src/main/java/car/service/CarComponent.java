package car.service;

import car.model.Dealership;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CarComponent {
    private final DealershipService dealershipService;
public CarComponent(DealershipService dealershipService) {
   this.dealershipService = dealershipService;
}
@PostConstruct
void init(){
    List<Dealership> dealerships = dealershipService.getAllDealerships();
    log.info("{}dealerships found", dealerships.size());;
    dealerships.forEach(dealership -> log.info("{}", dealership));
}
}
