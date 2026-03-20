package car.web.rest;


import car.model.Car;
import car.model.Dealership;
import car.service.CarService;
import car.service.DealershipService;
import car.web.rest.dto.CarDTO;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.util.List;
import java.util.Locale;
@RequestMapping("/webapi")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CarRest {
    private final DealershipService dealershipService;
    private final CarService carService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;


    @GetMapping("cars")
    List<Car> getCars(){
        log.info("Get cars");
        List<Car> cars = carService.getAllCars();
        log.info("{} cars found", cars.size());
        return cars;
    }
    @GetMapping("/cars/{id}")
    ResponseEntity<Car> getCar(@PathVariable("id") int id){
        log.info("Get car {}", id);
        Car car = carService.getCarById(id);
        log.info("{} car found", car);
        if(car != null){
            return ResponseEntity.ok(car);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/cars")
    ResponseEntity<?> addCar(@Validated @RequestBody CarDTO carDTO, Errors errors, HttpServletRequest request){
        log.info("about to add new car {}", carDTO);
        if(errors.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    //  .map(oe->messageSource.getMessage(oe, locale))
                    .map(oe->messageSource.getMessage(oe.getCode(),new Object[0], locale))
                    //W Formie wyżej mi nie znajdywało treści erroru
                    .reduce("error:\n", (accu, oe)->accu+oe+"\n");
            return ResponseEntity.badRequest().body(errorMessage);
        }
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        log.info("Add car {}", carDTO);
        Car car = new Car();
        car.setBrand(carService.getBrandById(carDTO.getBrandId()));
        car.setModel(carDTO.getModel());
        car.setPrice(carDTO.getPrice());

        car = carService.addCar(car);
        log.info("new car added: {}", car);
        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/" + car.getId())
                                .build()
                                .toUri())
                .body(car);

    }
}