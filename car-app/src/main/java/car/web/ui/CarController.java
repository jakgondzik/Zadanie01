package car.web.ui;

import car.model.Brand;
import car.model.Car;
import car.model.Dealership;
import car.service.CarService;
import car.service.DealershipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CarController {
    private final DealershipService dealershipService;
    private final CarService carService;
    @GetMapping("/cars")
    String getCars(
            Model model,
            @RequestParam(value = "dealershipId", required = false) Integer dealershipId,
            @RequestParam(value = "brandId", required = false) Integer brandId)
    {
            log.info("about to display cars list in dealership{}", dealershipId);
            if(dealershipId != null){
                Dealership dealership = dealershipService.getDealershipById(dealershipId);
                List<Car> cars = dealershipService.getCarsInDealership(dealership);
                model.addAttribute("cars", cars);
                model.addAttribute("title","Cars in dealership'" + dealership.getName() + "'");
            }
            else if(brandId != null){
                Brand brand = carService.getBrandById(brandId);
                List<Car> cars = carService.getCarsByBrand(brand);
                model.addAttribute("cars", cars);
                model.addAttribute("title","Cars by brand'" + brand.getName() + "'");
            }
            else{
                List<Car> cars= carService.getAllCars();
                model.addAttribute("cars", cars);
                model.addAttribute("title","Cars");
            }
            return "carsView";
    }
}
