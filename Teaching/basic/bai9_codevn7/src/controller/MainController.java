package controller;

import model.entities.Order;
import model.service.OrderService;

public class MainController {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        for (Order order : orderService.getAllOrders()) {
            System.out.println(order.toString());
        }
    }
}
