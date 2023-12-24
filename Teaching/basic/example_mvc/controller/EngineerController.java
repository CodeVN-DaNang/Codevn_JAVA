package controller;

import java.util.Scanner;

import model.entity.Engineer;
import model.service.EngineerService;

public class EngineerController {
    static Scanner sc = new Scanner(System.in);
    static EngineerService engineerService = new EngineerService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("MENU\n"
                    + "1. add new engineer\n"
                    + "2. delete enginner\n"
                    + "3. update engineer\n"
                    + "4. display all engineer\n"
                    + "5. exit");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addNewEnginner();
                    break;
                case 2:
                    deleteEnginner();
                    break;
                case 3:
                    updateEnginner();
                    break;
                case 4:
                    displayEnginner();
                    break;
                case 5:
                    System.exit(key);
                    break;
                default:
                    break;
            }
        }
    }

    private static void displayEnginner() {
        for (Engineer engineer : engineerService.getAllEngineers()) {
            System.out.println(engineer.toString());
        }
    }

    private static void updateEnginner() {
        displayEnginner();
        System.out.println("Input index to update:");
        int index = Integer.parseInt(sc.nextLine());
        Engineer engineer = engineerService.getAllEngineers().get(index);
        System.out.println(engineer.toString());

        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input age:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Input gender:");
        String gender = sc.nextLine();
        System.out.println("Input address:");
        String address = sc.nextLine();
        System.out.println("Input major:");
        String major = sc.nextLine();
        Engineer newEngineer = new Engineer(engineer.getId(), name, age, gender, address, major);
        engineerService.updateEnginner(index, newEngineer);
    }

    private static void deleteEnginner() {
        System.out.println("Input index to delete:");
        int id = Integer.parseInt(sc.nextLine());
        engineerService.deleteEngineer(id);
    }

    private static void addNewEnginner() {
        System.out.println("Input id:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input age:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Input gender:");
        String gender = sc.nextLine();
        System.out.println("Input address:");
        String address = sc.nextLine();
        System.out.println("Input major:");
        String major = sc.nextLine();
        Engineer engineer = new Engineer(id, name, age, gender, address, major);
        engineerService.addEngineer(engineer);
    }
}
