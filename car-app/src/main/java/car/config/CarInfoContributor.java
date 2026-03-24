package car.config;

import car.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarInfoContributor implements InfoContributor {
    private final CarService carService;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("cars",carService.getAllCars().size());
    }
}
