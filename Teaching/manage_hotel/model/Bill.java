package manage_hotel.model;

public class Bill {
    private String localDate;
    private Customer customer;
    private Room room;

    public Bill(String localDate, Customer customer, Room room) {
        this.localDate = localDate;
        this.customer = customer;
        this.room = room;
    }

    public String getLocalDate() {
        return localDate;
    }
    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Bill [localDate=" + localDate + ", customer=" + customer.toString() + ", room=" + room.toString() + "]";
    }
}
