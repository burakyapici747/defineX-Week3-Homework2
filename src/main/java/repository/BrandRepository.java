package repository;

import model.Brand;

import java.util.*;

public class BrandRepository {
    private Map<UUID, Brand> brands = new HashMap<>();

    public void save(Brand brand){
        brands.put(brand.getId(), brand);
    }

    public void deleteById(String id){
        brands.remove(UUID.fromString(id));
    }

    public List<Brand> getAll(){
        return new ArrayList<>(brands.values());
    }
}
