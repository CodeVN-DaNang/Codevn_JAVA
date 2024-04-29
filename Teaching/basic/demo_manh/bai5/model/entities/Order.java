package model.entities;

public class Order {
    // Số ngày thuê, loại phòng(tat ca thong tin phong), thông tin cá nhân của những người thuê phòng.
    private int dayRent;
    private Room room;
    private Customer customer;
    public Order(int dayRent, Room room, Customer customer) {
        this.dayRent = dayRent;
        this.room = room;
        this.customer = customer;
    }
    public Order() {
    }
    public int getDayRent() {
        return dayRent;
    }
    public void setDayRent(int dayRent) {
        this.dayRent = dayRent;
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
        return "Order [dayRent=" + dayRent + ", room=" + room + ", customer=" + customer + "]";
    }

    

}
