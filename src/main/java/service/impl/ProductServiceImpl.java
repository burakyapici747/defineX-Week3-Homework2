package service.impl;


import model.Brand;
import model.Product;
import repository.ProductRepository;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(String name, double price, Brand brand) {
        final Product product = new Product(name, price, brand);
        productRepository.create(product);
        return product;
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }
}
