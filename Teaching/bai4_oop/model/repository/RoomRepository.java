package model.repository;

import java.util.ArrayList;

import model.entity.Room;

public class RoomRepository {
    private ArrayList<Room> rooms = new ArrayList<>();

    public ArrayList<Room> getAllRoom() {
        Room roomA = new Room("Room A", 500);
        Room roomB = new Room("Room B", 300);
        Room roomC = new Room("Room C", 100);
        rooms.add(roomA);
        rooms.add(roomB);
        rooms.add(roomC);
        return this.rooms;
    }

    public Room getByIndex(int index) {
        return this.rooms.get(index);
    }

    public boolean addNew(int index, Room room) {
        return this.rooms.add(room);
    }

    public void edit(int index, Room room) {
        this.rooms.remove(index);
        this.rooms.add(index, room);
    }

    public void delete(int index) {
        this.rooms.remove(index);
    }
}
