package car.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
@RequiredArgsConstructor
public class CarAdvice {
    private final DealershipValidator validator;

    @InitBinder
    void initBinder(WebDataBinder binder) {binder.addValidators(validator);}
}
