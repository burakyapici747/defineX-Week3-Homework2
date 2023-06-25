package service;

import model.Customer;
import model.Order;
import model.Product;

import java.util.List;

public interface OrderService {
    Order create(String name, List<Product> products, Customer customer);
    void deleteById(String id);
    List<Order> getAll();
}
