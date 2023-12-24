public class Bill {
    private String dateRent;
    private Customer customer;
    private Room room;

    public Bill(String dateRent, Customer customer, Room room) {
        this.dateRent = dateRent;
        this.customer = customer;
        this.room = room;
    }

    public Bill() {
    }

    public String getDateRent() {
        return dateRent;
    }

    public void setDateRent(String dateRent) {
        this.dateRent = dateRent;
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
        return "Bill [dateRent=" + dateRent + ", customer=" + customer + ", room=" + room + "]";
    }
}
