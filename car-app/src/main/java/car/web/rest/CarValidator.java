package car.web.rest;

import car.model.Brand;
import car.model.Dealership;
import car.service.CarService;
import car.service.DealershipService;
import car.web.rest.dto.CarDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarValidator implements Validator {
    private final CarService carService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(CarDTO.class);
    }
    @Override
    public void validate(Object target, Errors errors) {
        CarDTO carDTO = (CarDTO) target;
        Brand brand = carService.getBrandById(carDTO.getBrandId());
        if (brand == null) {
            errors.rejectValue("brandId", "car.brand.missing");
        }
    }
}
