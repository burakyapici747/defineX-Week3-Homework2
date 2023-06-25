package service;

import model.Bill;
import model.Company;
import model.Customer;
import model.Order;

import java.util.List;

public interface BillService {
    Bill create(String name, Order order);
    void delete(String id);
    List<Bill> getAll();
    double getTotalPriceByCustomer(Customer customer);
    List<Bill> getAllBiggerThanByValue(double value);
    List<Bill> getAllSmallerThanByValue(double value);
    double calculateAverageOfBiggerThanByValue(double value);
    public List<Bill> getAllByCompany(Company company);
    public boolean checkIfCompanyBillsAverageSmallerThanValueInGivenMonth(Company company, double val, int month);
}
