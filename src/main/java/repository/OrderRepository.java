package repository;

import model.Order;

import java.util.*;

public class OrderRepository {
    private Map<UUID, Order> orders = new HashMap<>();

    public void create(Order order){
        orders.put(order.getId(), order);
    }

    public void deleteById(String id){
        orders.remove(UUID.fromString(id));
    }

    public List<Order> getAll(){
        return new ArrayList<>(orders.values());
    }
}
