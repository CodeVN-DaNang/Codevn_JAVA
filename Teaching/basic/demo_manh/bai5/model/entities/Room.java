package model.entities;

public class Room {
    private int roomId;
    private String roomType;
    private double price;

    public Room(int roomId, String roomType, double price) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
    }

    public Room() {
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room [roomId=" + roomId + ", roomType=" + roomType + ", price=" + price + "]";
    }

}
