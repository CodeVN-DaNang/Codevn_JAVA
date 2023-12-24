package manage_hotel.controller;

import java.util.ArrayList;
import java.util.Scanner;

import manage_hotel.model.Bill;
import manage_hotel.model.Room;

public class MainController {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Bill> bills = new ArrayList<>();
    public static void main(String[] args) {
        Room roomA = new Room("A01", "A", 500);
        Room roomB = new Room("B01", "B", 200);
        Room roomC = new Room("C01", "C", 100);
        while(true){
            System.out.println(" ----MENU----\n"
            +"1.Add customers.\n"
            +"2.Delete customers.\n"
            +"3.Price for the room.\n"
            +"4.Exit.\n"
            +"What do you want :");
            int key = Integer.parseInt(scanner.nextLine());
            switch (key) {
                case 1:
                    addCustomers();
                    break;
                case 2:
                    deleteCustomers();
                    break;
                case 3:
                    progressPrice();
                    break;
                case 4:
                    System.out.println("Thank you for using.");
                    return;
                default:
                    break;
            }
        }
    }

    private static void progressPrice() {
        for (int i = 0; i < bills.size(); i++) {
            System.out.println(bills.get(i).toString());
        }
        System.out.println("Nhap cai can in ra gia tien:");
        int i = Integer.parseInt(scanner.nextLine());
        System.out.println("Tong tien:" + (Integer.parseInt(bills.get(i).getLocalDate())*bills.get(i).getRoom().getPrice()));
    }

    private static void deleteCustomers() {

    }

    private static void addCustomers() {

    }

    
}
