package repository;

import model.Product;

import java.util.*;

public class ProductRepository {
    private Map<UUID, Product> products = new HashMap<>();

    public void create(Product product){
        products.put(product.getId(), product);
    }

    public void deleteById(String id){
        products.remove(UUID.fromString(id));
    }

    public List<Product> getAll(){
        return new ArrayList<>(products.values());
    }

}
