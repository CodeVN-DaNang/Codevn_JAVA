package view;

import java.util.Scanner;

import controller.PersonController;
import model.entity.Person;

public class PersonMenu {
    Scanner sc = new Scanner(System.in);
    PersonController personController = new PersonController();
    public int displayPersonMenu() {
        System.out.println("----PERSON MENU----\n"
            + "1. add\n"
            + "2. edit\n"
            + "3. search\n"
            + "4. delete"
            + "5. exit"
        );
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }

    public void displayAllPeople(){
        personController.getAllPerson();
    }

    public Person addView() {
        System.out.println("Input name");
        String name = sc.nextLine();
        System.out.println("Input age");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Input id:");
        String id = sc.nextLine();
        Person person = new Person(name, age, id);
        return person;
    }
}
