package manage_hotel.model;

public class Room {
    private String id;
    private String typeRoom;
    private int price;

    public Room(String id, String typeRoom, int price) {
        this.id = id;
        this.typeRoom = typeRoom;
        this.price = price;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTypeRoom() {
        return typeRoom;
    }
    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room [id=" + id + ", typeRoom=" + typeRoom + ", price=" + price + "]";
    }
}
