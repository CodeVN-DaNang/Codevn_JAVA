package model.entity;

public class Bill {
    private int dateUse;
    private Room room;
    private Person person;
    public Bill(int dateUse, Room room, Person person) {
        this.dateUse = dateUse;
        this.room = room;
        this.person = person;
    }
    public int getDateUse() {
        return dateUse;
    }
    public void setDateUse(int dateUse) {
        this.dateUse = dateUse;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    @Override
    public String toString() {
        return "Bill [dateUse=" + dateUse + ", room=" + room + ", person=" + person + "]";
    }
}
