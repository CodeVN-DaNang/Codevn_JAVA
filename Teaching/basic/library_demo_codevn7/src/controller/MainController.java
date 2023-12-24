package controller;

import java.util.Scanner;

import model.service.MainService;

public class MainController {
    Scanner sc = new Scanner(System.in);
    MainService mainService = new MainService();
    CustomerController customerController = new CustomerController();
    EmployeeController employeeController = new EmployeeController();

    public int mainMenu() {
        System.out.println("----MENU LIBRARY----\n"
                + "1. Login\n"
                + "2. Register\n"
                + "3. Guest\n"
                + "4. Exit");
        int key = Integer.parseInt(sc.nextLine());
        switch (key) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                // hien list of document
                break;
            case 4:
                System.exit(0);
            default:
                break;
        }
        return mainMenu();
    }

    private void register() {
        customerController.addCustomer();
    }

    private void login() {
        System.out.println("Input username:");
        String username = sc.nextLine();
        System.out.println("Input password:");
        String password = sc.nextLine();
        String infor = mainService.login(username, password);
        if (infor != null) {
            System.out.println("Login success");
            System.out.println("Hello " + infor);
            if (infor.contains("Employee")) {
                employeeController.employeeMenu();
                return;
            }
            customerController.customerMenu();
        }
    }
}
