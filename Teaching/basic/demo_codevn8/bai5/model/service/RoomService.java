package model.service;

import java.util.ArrayList;

import model.entities.Room;
import model.repo.RoomRepo;

public class RoomService {
    RoomRepo roomRepo = new RoomRepo();

    public ArrayList<Room> getAll(){
        return roomRepo.getAll();
    }

    public Room getById(int id){
        return roomRepo.getById(id);
    }

    public void add(Room room){
        roomRepo.add(room);
    }

    public void delete(int id){
        roomRepo.delete(id);
    }

    public void update(Room room){
        roomRepo.update(room);
    }

}
