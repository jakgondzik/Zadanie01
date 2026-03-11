package car.web.rest;

import car.model.Car;
import car.model.Dealership;
import car.service.CarService;
import car.service.DealershipService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DealershipRest {
    private final DealershipService dealershipService;
    private final CarService carService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    private final DealershipValidator validator;
    //@InitBinder
   //void initBinder(WebDataBinder binder) { binder.addValidators(validator); }

    @GetMapping("/dealerships")
    List<Dealership> getDealerships(
            @RequestParam(value = "phrase", required = false) String phase,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie
    ){
        log.info("about to retreive dealerships");
        log.info("phase is {}", phase);
        log.info("custom-header is {}", customHeader);
        log.info("some cookie is {}", someCookie);
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
    ResponseEntity<?> addDealership(@Validated @RequestBody Dealership dealership, Errors errors,  HttpServletRequest request) {
        log.info("about to add dealership {}", dealership);
        if(errors.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                  //  .map(oe->messageSource.getMessage(oe, locale))
                                       .map(oe->messageSource.getMessage(oe.getCode(),new Object[0], locale))
                    //W Formie wyżej mi nie znajdywało treści erroru
                    .reduce("error:\n", (accu, oe)->accu+oe+"\n");
            return ResponseEntity.badRequest().body(errorMessage);
        }
        dealership = dealershipService.addDealership(dealership);
        log.info("{} dealership added", dealership);
        return ResponseEntity.status(HttpStatus.CREATED).body(dealership);
    }
}
