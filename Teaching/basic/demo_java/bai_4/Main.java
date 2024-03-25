package bai_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Human> humanList = new ArrayList<>();
    static ArrayList<Home> homeList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Input amount of homes:");
        int amountHomes = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < amountHomes; i++) {
            addHome();
        }
        System.out.println("Input home to display family member:");
        String homeAddress = sc.nextLine();
        for (Human human : humanList) {
            if (human.getHome().getHomeNumber().equals(homeAddress)) {
                System.out.println(human.toString());
            }
        }
    }

    public static void addHome(){
        System.out.println("Input address:");
        String address = sc.nextLine();
        System.out.println("Amount of people:");
        int amount = Integer.parseInt(sc.nextLine());
        Home home = new Home(address, amount);
        homeList.add(home);
        for (int i = 0; i < amount; i++) {
            addPeople(home);
        }
    }

    public static void addPeople(Home home){
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input age:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Input job:");
        String job = sc.nextLine();
        System.out.println("Input id:");
        String id = sc.nextLine();
        Human human = new Human(name, age, job, id, home);
        humanList.add(human);
    }
}
