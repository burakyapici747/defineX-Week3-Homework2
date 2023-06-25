package service.impl;

import model.Customer;
import repository.CustomerRepository;
import service.CustomerService;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(String name, String surname, String email, String number) {
        Customer customer = new Customer(name, surname, email, number);
        customerRepository.create(customer);
        return customer;
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public List<Customer> getCustomersWithCharacter(char chr) {
        return customerRepository.getAll().stream()
                .filter(customer -> customer.getName().contains(String.valueOf(chr)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getAllByMonthCustomers(int month) {
        return customerRepository.getAll().stream()
                .filter(customer -> customer.getCreatedAt().getMonth() == Month.of(month))
                .collect(Collectors.toList());
    }
}
