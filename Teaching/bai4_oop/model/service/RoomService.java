package model.service;

import java.util.ArrayList;

import model.entity.Room;
import model.repository.RoomRepository;

public class RoomService {
    RoomRepository RoomRepository = new RoomRepository();

    public ArrayList<Room> getAllRoom() {
        return this.RoomRepository.getAllRoom();
    }

    public Room getRoomById(int id) {
        return this.RoomRepository.getByIndex(id);
    }

    public ArrayList<Room> findByName(String name) {
        ArrayList<Room> rooms = getAllRoom();
        ArrayList<Room> finds = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getName().contains(name)) {
                finds.add(rooms.get(i));
            }
        }
        return finds;
    }

    public boolean addNew(Room room) {
        return this.RoomRepository.addNew(0, room);
    }

    public void edit(int index, Room room) {
        this.RoomRepository.delete(index);
        this.RoomRepository.addNew(index, room);
    }

    public void delete(int index) {
        this.RoomRepository.delete(index);
    }
}
