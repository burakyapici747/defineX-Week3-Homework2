package service;

import model.Brand;
import model.Company;

import java.util.List;

public interface BrandService {
    Brand create(String name, Company company);
    void deleteById(String id);
    List<Brand> getAll();
}
