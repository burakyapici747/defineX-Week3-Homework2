package service.impl;

import model.Customer;
import model.Order;
import model.Product;
import repository.OrderRepository;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(String name, List<Product> products, Customer customer) {
        final Order order = new Order(name, products, customer);
        orderRepository.create(order);
        return order;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
