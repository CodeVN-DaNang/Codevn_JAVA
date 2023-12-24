package controller;

import model.entity.Room;
import model.service.RoomService;

public class RoomController {
    RoomService roomService = new RoomService();
    public Room findById(int id) {
        return roomService.getRoomById(id);
    }
}
