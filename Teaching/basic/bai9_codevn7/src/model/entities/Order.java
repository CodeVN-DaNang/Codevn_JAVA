package model.entities;

public class Order {
    private Customer customer;
    private int oldE;
    private int newE;
    private int price;

    public Order(Customer customer, int oldE, int newE, int price) {
        this.customer = customer;
        this.oldE = oldE;
        this.newE = newE;
        this.price = price;
        setPrice();
    }

    public Order() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOldE() {
        return oldE;
    }

    public void setOldE(int oldE) {
        this.oldE = oldE;
    }

    public int getNewE() {
        return newE;
    }

    public void setNewE(int newE) {
        this.newE = newE;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice() {
        this.price = (this.newE - this.oldE) * 5;
    }

    @Override
    public String toString() {
        return "Order [customer=" + customer.toString() + ", oldE=" + oldE + ", newE=" + newE + ", price=" + price + "]";
    }

}