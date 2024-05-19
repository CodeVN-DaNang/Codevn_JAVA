package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.entities.Room;
import model.service.RoomService;

public class MainController {
    static RoomService roomService = new RoomService();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("----MENU ROOM----\n"
                    + "1. add\n"
                    + "2. delete\n"
                    + "3. update\n"
                    + "4. search id\n"
                    + "5. show rooms\n"
                    + "6. exit\n");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    show();
                    break;
                case 6:
                    System.exit(1);
                    break;
                default:
                    break;
            }
        }
    }

    private static void show() {
        for (Room room : roomService.getAll()) {
            System.out.println(room);
        }    
    }

    private static void search() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    private static void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    private static void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private static void add() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    

}
