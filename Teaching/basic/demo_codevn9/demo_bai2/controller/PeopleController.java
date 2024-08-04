package demo_bai2.controller;

import java.util.Scanner;

import demo_bai2.model.entities.Person;
import demo_bai2.model.service.PersonService;

public class PeopleController {

    Scanner sc = new Scanner(System.in);
    PersonService personService = new PersonService();

    public void displayMenu(){
        System.out.println("----PEOPLE MENU----\n"
            + "1. Add new person"
        );
        int key = Integer.parseInt(sc.nextLine());
        switch (key) {
            case 1:
                addNewPerson();
                break;
        
            default:
                break;
        }
    }

    private void addNewPerson() {
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input age:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Input job:");
        String job = sc.nextLine();
        System.out.println("Input id:");
        String id = sc.nextLine();
        Person person = new Person(name, age, job, id);
        personService.add(person);
    }
}
