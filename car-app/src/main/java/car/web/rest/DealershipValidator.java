package car.web.rest;

import car.model.Dealership;
import car.service.DealershipService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DealershipValidator implements Validator {
    private final DealershipService dealershipService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Dealership.class);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Dealership validatedDealership = (Dealership) target;
        boolean duplicated = dealershipService.getAllDealerships().stream()
                .anyMatch(dealership->dealership.getName().equalsIgnoreCase(validatedDealership.getName()));
        if (duplicated) {
            errors.rejectValue("name", "duplicated");
        }
    }
}
