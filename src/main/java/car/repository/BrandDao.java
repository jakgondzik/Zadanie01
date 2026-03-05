package car.repository;

import car.model.Brand;

import java.util.List;

public interface BrandDao {
    List<Brand> findAll();
    Brand findById(int id);
    Brand add(Brand b);
}
