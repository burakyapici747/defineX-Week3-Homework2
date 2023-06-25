package model;

public class Bill extends BaseModel{
    private String name;
    private double amount;
    private Order order;

    public Bill(String name, Order order) {
        this.name = name;
        this.amount = 0.0;
        this.order = order;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", order=" + order +
                "} " + super.toString();
    }
}
