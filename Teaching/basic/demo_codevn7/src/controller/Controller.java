package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.entity.Employee;
import model.service.EmployeeService;

public class Controller {
    static Scanner sc = new Scanner(System.in);
    static EmployeeService employeeService = new EmployeeService();
    static int currentIndex = employeeService.getAllEmployee().size()+1;

    public static void main(String[] args) {
        while (true) {
            
            System.out.println("----MENU----\n"
                    + "1. Add new employee\n"
                    + "2. Delete employee\n"
                    + "3. Update employee\n"
                    + "4. Display employee\n"
                    + "5. Search employee\n"
                    + "6. Exit");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    display(employeeService.getAllEmployee());
                    break;
                case 5:
                    searchEmployee();
                    break;
                case 6:
                    return;
                default:
                    break;
                
            }
        }
    }

    private static void searchEmployee() {
        System.out.println("Enter name:");
        String name = sc.nextLine();
        display(employeeService.searchEmployees(name));
    }

    private static void display(ArrayList<Employee> allEmployee) {
        for (Employee employee : allEmployee) {
            System.out.println(employee.toString());
        }
    }

    private static void updateEmployee() {
        System.out.println("Enter id:");
        int id = Integer.parseInt(sc.nextLine());
        Employee employee = employeeService.getEmployeeById(id);
        System.out.println(employee.toString());
        System.out.println("Enter name:");
        String name = sc.nextLine();
        if (name.equals("")) {
            name = employee.getName();
        }
        System.out.println("Enter email:");
        String email = sc.nextLine();
        if (email.equals("")) {
            email = employee.getEmail();
        }
        System.out.println("Enter phone:");
        String phone = sc.nextLine();
        if (phone.equals("")) {
            phone = employee.getPhone();
        }
        employee = new Employee(id, name, email, phone);
        employeeService.updateEmployee(employee);
    }

    private static void deleteEmployee() {
        System.out.println("Enter id:");
        int id = Integer.parseInt(sc.nextLine());
        employeeService.deleteEmployee(id);
    }

    private static void addEmployee() {
        System.out.println("Enter name:");
        String name = sc.nextLine();
        System.out.println("Enter email:");
        String email = sc.nextLine();
        System.out.println("Enter phone:");
        String phone = sc.nextLine();
        Employee employee = new Employee(currentIndex, name, email, phone);
        employeeService.addEmployee(employee);
    }
}
