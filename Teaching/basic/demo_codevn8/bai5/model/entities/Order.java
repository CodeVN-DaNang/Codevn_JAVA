package model.entities;

public class Order {
    private int id;
    private int rentalDay;
    private Room room;
    private Customer customer;
    public Order() {
    }
    public Order(int id, int rentalDay, Room room, Customer customer) {
        this.id = id;
        this.rentalDay = rentalDay;
        this.room = room;
        this.customer = customer;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getRentalDay() {
        return rentalDay;
    }
    public void setRentalDay(int rentalDay) {
        this.rentalDay = rentalDay;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Override
    public String toString() {
        return "Order [id=" + id + ", rentalDay=" + rentalDay + ", room=" + room.toString() + ", customer=" + customer.toString() + "]";
    }

    
}
