package car.web.ui;

import car.model.Dealership;
import car.service.DealershipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class DealershipController {
    private final DealershipService dealershipService;
    @GetMapping("/dealerships")
    String getDealerships(Model model) {
     log.info("getCinemas");
        List<Dealership> dealerships = dealershipService.getAllDealerships();
        model.addAttribute("dealerships", dealerships);
        return "dealershipsView";

    }
}
