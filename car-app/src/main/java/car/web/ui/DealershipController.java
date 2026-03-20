package car.web.ui;

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
public class DealershipController {
    private final DealershipService dealershipService;
    private final CarService carService;
    @GetMapping("/dealerships")
    String getDealerships(
            Model model,
            @RequestParam(value="carId", required = false) Integer carId) {
     log.info("about to display dealerships list selling car {}", carId);
     if(carId != null){
         Car car = carService.getCarById(carId);
         List<Dealership> dealerships = dealershipService.getDealershipsByCar(car);
         model.addAttribute("dealerships", dealerships);
         model.addAttribute("title","dealerships selling '" + car.getModel() + "'");
     }
     else{
         List<Dealership> dealerships = dealershipService.getAllDealerships();
         model.addAttribute("dealerships", dealerships);
         model.addAttribute("title","Dealerships");

     }
        return "dealershipsView";

    }
}
