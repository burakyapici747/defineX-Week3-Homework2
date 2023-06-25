package service.impl;

import model.Brand;
import model.Company;
import repository.BrandRepository;
import service.BrandService;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand create(String name, Company company) {
        Brand brand = new Brand(name, company);
        brandRepository.save(brand);
        return brand;
    }

    @Override
    public void deleteById(String id) {
        brandRepository.deleteById(id);
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.getAll();
    }
}
