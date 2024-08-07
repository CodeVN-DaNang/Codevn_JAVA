package controller;

import java.util.Scanner;

import model.entities.Home;
import model.entities.Person;
import model.service.HomeService;
import model.service.PersonService;



public class HomeController {
    Scanner sc = new Scanner(System.in);
    HomeService homeService = new HomeService();
    PeopleController peopleController = new PeopleController();
    PersonService personService = new PersonService();

    public void displayMenu() {
        System.out.println("----HOME MENU----\n"
            + "1. Add new home\n"
            + "2. Show all home"
        );
        int key = Integer.parseInt(sc.nextLine());
        switch (key) {
            case 1:
                addNewHome();
                break;
            case 2:
                showAllHome();
                break;
            default:
                break;
        }
    }

    public void addNewHome(){
        System.out.println("Input amount people:");
        int amountPeople = Integer.parseInt(sc.nextLine());
        System.out.println("Input home number:");
        String homeNumber = sc.nextLine();
        int count = 0;
        while (count < amountPeople) {
            peopleController.addNewPerson(homeNumber);
            count++;
        }
        Home home = new Home(amountPeople, homeNumber);
        homeService.add(home);
    }

    public void showAllHome(){
        for (Home home : homeService.getAll()) { // {[1,Nhat,24], [2,Quan,20], [3,Hieu,21]}
            System.out.println(home.toString());
            showAllPeopleByHome(home.getHomeNumber());
        }
    }

    public void showAllPeopleByHome(String homeNumber){
        for (Person person : personService.getAll()) {
            if (person.getHomeNumber().equals(homeNumber)) {
                System.out.println(person.toString());
            }
        }
    }

}
