package view;

import java.util.Scanner;

import controller.PersonController;
import controller.RoomController;
import model.entity.Bill;
import model.entity.Person;
import model.entity.Room;

public class BillMenu {
    Scanner sc = new Scanner(System.in);
    PersonMenu personMenu = new PersonMenu();
    PersonController personController = new PersonController();
    RoomController roomController = new RoomController();
    public int displayBillMenu() {
        System.out.println("Bill Menu");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }

    public Bill addBillView() {
        int dateUse = Integer.parseInt(sc.nextLine());
        System.out.println("Choose type of room");
        int idRoom = Integer.parseInt(sc.nextLine());
        Room room = roomController.findById(idRoom);
        System.out.println("Customer used or Customer new:");
        int key = Integer.parseInt(sc.nextLine());
        Person person = new Person();
        switch (key) {
            case 1:
                personMenu.displayAllPeople();
                int choose = Integer.parseInt(sc.nextLine());
                person = personController.findById(choose);
                break;
            case 2:
                person = personController.addPerson();
            default:
                break;
        }
        Bill bill = new Bill(dateUse, room, person);
        return bill;
    }
}
