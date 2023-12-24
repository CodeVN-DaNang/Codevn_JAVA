package model.entity;

public class Room {
    private String name;
    private int price;
    public Room(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public Room(){}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Room [name=" + name + ", price=" + price + "]";
    }
}
