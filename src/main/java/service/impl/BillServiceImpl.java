package service.impl;

import model.*;
import repository.BillRepository;
import service.BillService;

import java.time.Month;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public Bill create(String name, Order order) {
        Bill bill = new Bill(name, order);

        bill.setAmount(order.getProducts().stream().mapToDouble(Product::getPrice).sum());
        billRepository.create(bill);

        return bill;
    }

    @Override
    public void delete(String id) {
        billRepository.deleteById(id);
    }

    @Override
    public List<Bill> getAll() {
        return billRepository.getAll();
    }

    @Override
    public double getTotalPriceByCustomer(Customer customer) {
        return billRepository.getAll().stream()
                .filter(bill -> bill.getOrder().getCustomer().equals(customer))
                .mapToDouble(Bill::getAmount)
                .sum();
    }

    @Override
    public List<Bill> getAllBiggerThanByValue(double value) {
        return billRepository.getAll().stream()
                .filter(bill -> bill.getAmount() > value)
                .collect(Collectors.toList());
    }

    @Override
    public List<Bill> getAllSmallerThanByValue(double value) {
        return billRepository.getAll().stream()
                .filter(bill -> bill.getAmount() < value)
                .collect(Collectors.toList());
    }

    @Override
    public double calculateAverageOfBiggerThanByValue(double value) {
        return billRepository.getAll().stream()
                .filter(bill -> bill.getAmount() > value)
                .mapToDouble(Bill::getAmount)
                .average()
                .orElse(0.0);
    }

    @Override
    public boolean checkIfCompanyBillsAverageSmallerThanValueInGivenMonth(Company company, double val, int month){
        OptionalDouble result = getAllByCompany(company).stream()
                .filter(bill -> bill.getCreatedAt().getMonth() == Month.of(month))
                .mapToDouble(Bill::getAmount)
                .average();
        return result.isPresent() && result.getAsDouble() < val;
    }

    @Override
    public List<Bill> getAllByCompany(Company company) {
        return billRepository.getAll().stream().filter(bill -> bill.getOrder().
                        getProducts().stream().findFirst().get().getBrand().getCompany().equals(company))
                .collect(Collectors.toList());
    }
}
