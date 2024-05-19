package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entities.Room;

public class RoomRepo {
    ArrayList<Room> rooms = new ArrayList<>();

    public void read(){
        rooms.clear();
        try {
            FileReader fr = new FileReader("/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_codevn8/bai5/data/Room.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                int price = Integer.parseInt(arr[2]);
                Room room = new Room(id, name, price);
                rooms.add(room);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write(){
        try {
            FileWriter fw = new FileWriter("/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_codevn8/bai5/data/Room.txt");
            String line = "";
            for (Room room : rooms) {
                line += room.getId() + "," + room.getName() + "," + room.getPrice() + "/n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Room> getAll(){
        read();
        return this.rooms;
    }

    public Room getById(int id){
        read();
        for (Room room : rooms) {
            if (room.getId() == id) {
                return room;
            }
        }
        return null;
    }

    public void add(Room room){
        rooms.add(room);
        write();
    }

    public void delete(int id){
        for (Room room : rooms) {
            if (room.getId() == id) {
                rooms.remove(room);
            }
        }
        write();
    }

    public void update(Room newRoom){
        int count = 0;
        for (Room room : rooms) {
            if (room.getId() == newRoom.getId()) {
                rooms.set(count, newRoom);
            }
            count++;
        }
    }

}
