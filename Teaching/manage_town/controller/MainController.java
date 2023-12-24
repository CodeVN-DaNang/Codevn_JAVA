package manage_town.controller;

import java.util.ArrayList;
import java.util.Scanner;

import manage_town.model.Family;
import manage_town.model.People;

public class MainController {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Family> town43s = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("----MENU----\n"
                    + "1. Input information family\n"
                    + "2. Display all families\n");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addNewFam();
                    break;
                case 2:
                    displayAllFam();
                    break;
                default:
                    break;
            }
        }

    }

    private static void displayAllFam() {
        for (int i = 0; i < town43s.size(); i++) {
            System.out.println(town43s.get(i).toString());
        }
    }

    private static void addNewFam() {
        ArrayList<People> peoples = new ArrayList<>();
        System.out.println("input total mems:");
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            peoples.add(addNewPeople());
        }
        System.out.println("input total mems:");
        String address = sc.nextLine();
        Family newFam = new Family(address, peoples);
        town43s.add(newFam);
    }

    private static People addNewPeople() {
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input age:");
        String age = sc.nextLine();
        System.out.println("Input job:");
        String major = sc.nextLine();
        System.out.println("Input idCard:");
        String idCard = sc.nextLine();
        People newPerson = new People(idCard, name, age, major);
        return newPerson;
    }
}
