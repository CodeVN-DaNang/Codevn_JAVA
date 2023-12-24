package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.entities.Employee;
import model.service.EmployeeService;

public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();
    Scanner sc = new Scanner(System.in);

    public void employeeMenu() {
        while (true) {
            System.out.println("----MENU----\n"
                + "1. display all\n"
                + "2. add Employee\n"
                + "3. delete Employee\n"
                + "4. update Employee\n"
                + "5. search Employee\n"
                + "6. exit"
            );
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    displayEmployee(employeeService.getAllEmployees());
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    searchEmployee();
                    break;
                case 6:
                    System.out.println("Thank you");
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    private void searchEmployee() {
        System.out.println("Input phone to search: ");
        String phone = sc.nextLine();
        displayEmployee(employeeService.searchEmployeeByPhone(phone));

    }

    private void updateEmployee() {
        System.out.println("Input username to edit: ");
        String username = sc.nextLine();
        
        Employee Employee = employeeService.getEmployeeByUsername(username);

        System.out.println("Input name:");
        String name = sc.nextLine();
        if (name.equals("")) {
            name = Employee.getName();
        }

        System.out.println("Input email:");
        String email = sc.nextLine();
        if (email.equals("")) {
            email = Employee.getName();
        }

        System.out.println("Input phone:");
        String phone = sc.nextLine();
        if (phone.equals("")) {
            phone = Employee.getName();
        }

        System.out.println("Input password:");
        String password = sc.nextLine();
        if (password.equals("")) {
            password = Employee.getName();
        }

        Employee employee2 = new Employee(name, email, phone, username, password);
        if (employeeService.updateEmployee(employee2)) {
            System.out.println("Edit success...");
            return;
        }
        System.out.println("Edit failed...");
    }

    private void deleteEmployee() {
        System.out.println("Input username to delete: ");
        String username = sc.nextLine();
        if (employeeService.deleteEmployee(username)) {
            System.out.println("Delete success...");
            return;
        }
        System.out.println("Delete failed...");
    }

    private void addEmployee() {
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input email:");
        String email = sc.nextLine();
        System.out.println("Input phone:");
        String phone = sc.nextLine();
        System.out.println("Input username:");
        String username = "";
        while (!employeeService.checkUniqueUsername(username) && !username.equals("")) {
            username = sc.nextLine();
        }
        System.out.println("Input password:");
        String password = sc.nextLine();
        Employee Employee = new Employee(name, email, phone, username, password);
        employeeService.addEmployee(Employee);
    }

    private void displayEmployee(ArrayList<Employee> allEmployees) {
        int count = 0;
        for (Employee Employee : allEmployees) {
            System.out.println(++count + ", " + Employee.toString());
        }
    }

}
