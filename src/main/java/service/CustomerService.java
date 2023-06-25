package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(String name, String surname, String email, String number);
    void delete(String id);
    List<Customer> getAll();
    List<Customer> getCustomersWithCharacter(char chr);
    List<Customer> getAllByMonthCustomers(int month);
}
