package car;

import car.model.Dealership;
import car.service.DealershipService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class CarComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {
    private final DealershipService dealershipService;
public CarComponent(DealershipService dealershipService) {
   this.dealershipService = dealershipService;
}
@Override
public void run(String... args){
    log.info("Program arguments: {}", Arrays.toString(args));
}
@Override
public void onApplicationEvent(ContextRefreshedEvent event) {
    log.info("on context refreshed");
    List<Dealership> dealerships = dealershipService.getAllDealerships();
    log.info("dealerships: {}", dealerships.size());
    dealerships.forEach(dealership -> log.info("dealership: {}", dealership));
}
@EventListener
public void eventListener(ContextRefreshedEvent event){
    log.info("ON CONTEXT REFRESHED FROM ANOTHER METHOD");
}
@PostConstruct
void init(){
    List<Dealership> dealerships = dealershipService.getAllDealerships();
    log.info("{}dealerships found", dealerships.size());;
    dealerships.forEach(dealership -> log.info("{}", dealership));
}
}
