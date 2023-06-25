package repository;

import model.Customer;

import java.util.*;

public class CustomerRepository {
    private Map<UUID, Customer> customers = new HashMap<>();

    public void create(Customer customer){
       customers.put(customer.getId(), customer);
    }

    public void deleteById(String id){
        customers.remove(id);
    }

    public List<Customer> getAll(){
        return new ArrayList<>(customers.values());
    }
}
