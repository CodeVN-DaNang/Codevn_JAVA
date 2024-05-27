package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entities.Customer;
import model.entities.Order;
import model.entities.Room;

public class OrderRepo {
    ArrayList<Order> orders = new ArrayList<>();

    CustomerRepo customerRepo = new CustomerRepo();
    RoomRepo roomRepo = new RoomRepo();

    public void read() {
        orders.clear();
        try {
            FileReader fr = new FileReader(
                    "/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_codevn8/bai5/data/Order.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) { // 1,10,1,1
                String[] arr = line.split(","); // {"1", "10", "1", "1"}
                int id = Integer.parseInt(arr[0]);
                int rentalDay = Integer.parseInt(arr[1]);
                int customerId = Integer.parseInt(arr[2]);
                Customer customer = customerRepo.getById(customerId);
                int roomId = Integer.parseInt(arr[3]);
                Room room = roomRepo.getById(roomId);
                Order order = new Order(id, rentalDay, room, customer);
                orders.add(order);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write() {
        try {
            FileWriter fw = new FileWriter(
                    "/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_codevn8/bai5/data/Order.txt");
            String line = "";
            for (Order order : orders) {
                line += order.getId() + "," + order.getRentalDay() + "," + order.getCustomer().getId() + "," + order.getRoom().getId() + "/n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
