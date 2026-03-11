package car.web.rest.dto;

import car.model.Brand;
import lombok.Data;

@Data
public class CarDTO {
    private String model;
    private float price;
    private int brandId;
}
