package car.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice(basePackages = "car.web.rest")
@RequiredArgsConstructor
@Slf4j
public class CarAdvice {
    private final CarValidator carValidator;
    private final DealershipValidator dealershipValidator;


    @InitBinder("dealership")
    void initBinderForDealership(WebDataBinder binder) {binder.addValidators(dealershipValidator);}
    @InitBinder("carDTO")
    void initBinderForCar(WebDataBinder binder) {binder.addValidators(carValidator);}


    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleBadRequest(IllegalArgumentException e) {
        log.error("illegal argument provided", e);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
    }

}
