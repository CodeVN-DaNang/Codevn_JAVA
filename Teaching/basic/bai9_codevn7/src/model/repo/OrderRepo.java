package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.entities.Customer;
import model.entities.Order;

public class OrderRepo {
    ArrayList<Order> orderList = new ArrayList<>();
    CustomerRepo customerRepo = new CustomerRepo();

    void read() {
        try {
            FileReader fr = new FileReader(
                    "/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/bai9_codevn7/src/data/Order.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                String customerCode = arr[0];
                Customer customer = customerRepo.getCustomerByCode(customerCode);
                int oldE = Integer.parseInt(arr[1]);
                int newE = Integer.parseInt(arr[2]);
                Order order = new Order(customer, oldE, newE, 0);
                orderList.add(order);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Order> getAllOrders(){
        read();
        return orderList;
    }

}
