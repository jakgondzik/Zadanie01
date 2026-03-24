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
        boolean duplicated = carService.getAllCars().stream()
                .anyMatch(car ->
                        car.getModel().equalsIgnoreCase(carDTO.getModel()) &&
                                car.getBrand().getId() == carDTO.getBrandId()
                );

        if (duplicated) {

            errors.rejectValue("model", "duplicated", "Samochód o tym modelu i marce już istnieje!");
        }
    }
}
