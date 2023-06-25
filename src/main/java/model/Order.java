package model;

import java.time.LocalDateTime;
import java.util.List;

public class Order extends BaseModel{
    private String name;
    private Customer customer;
    private LocalDateTime createdDate;
    private double sum;
    private List<Product> products;

    public Order(String name, List<Product> products, Customer customer) {
        this.name = name;
        this.products = products;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", name='" + name + '\'' +
                ", customer=" + customer +
                ", createdDate=" + createdDate +
                ", sum=" + sum +
                ", products=" + products +
                "} " + super.toString();
    }
}
