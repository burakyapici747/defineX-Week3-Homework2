package service;

import model.Brand;
import model.Product;

import java.util.List;

public interface ProductService {
    Product create(String name, double price, Brand brand);
    void deleteById(String id);
    List<Product> getAll();
}
