package car.web.rest;

import car.model.Car;
import car.model.Dealership;
import car.service.CarService;
import car.service.DealershipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DealershipRest {
    private final DealershipService dealershipService;
    private final CarService carService;


    @GetMapping("/dealerships")
    List<Dealership> getDealerships(
            @RequestParam(value = "phrase", required = false) String phase,
            @RequestHeader(value = "custom-header", required = false) String customHeader
    ){
        log.info("about to retreive dealerships");
        log.info("phase is {}", phase);
        List<Dealership> dealerships = dealershipService.getAllDealerships();
        log.info("{} dealerships found", dealerships.size());
        return dealerships;
    }

    @GetMapping("/dealerships/{id}")
    ResponseEntity<Dealership> getDealership(@PathVariable("id") int id) {
        log.info("about to retreive dealership with id {}", id);
        Dealership dealership = dealershipService.getDealershipById(id);
        log.info("{} dealership found", dealership);
        if(dealership != null) {
            return ResponseEntity.status(200).body(dealership);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("cars/{carId}/dealerships")
    ResponseEntity<List<Dealership>> getDealershipsByCarId(@PathVariable("carId") int carId) {
        log.info("about to retreive dealerships by car id {}", carId);
        Car car = carService.getCarById(carId);
        if(car != null) {
            List<Dealership> dealerships = dealershipService.getDealershipsByCar(car);
            log.info("{} dealerships found", dealerships.size(),car.getModel());
            return ResponseEntity.ok(dealerships);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/dealerships")
    ResponseEntity<Dealership> addDealership(@RequestBody Dealership dealership) {
        log.info("about to add dealership {}", dealership);
        dealership = dealershipService.addDealership(dealership);
        log.info("{} dealership added", dealership);
        return ResponseEntity.status(HttpStatus.CREATED).body(dealership);
    }
}
