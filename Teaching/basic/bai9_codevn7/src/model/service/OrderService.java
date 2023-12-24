package model.service;

import java.util.ArrayList;

import model.entities.Order;
import model.repo.OrderRepo;

public class OrderService {
    OrderRepo orderRepo = new OrderRepo();

    public ArrayList<Order> getAllOrders(){
        ArrayList<Order> orderList = orderRepo.getAllOrders();
        if (orderList.isEmpty()) {
            return null;
        }
        return orderList;
    }

}
