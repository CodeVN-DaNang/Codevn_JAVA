package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.entities.Employee;
import model.entities.Engineer;
import model.entities.Staff;
import model.entities.Worker;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("----MENU----\n"
                    + "1. Thêm mới cán bộ.\n"
                    + "2. Tìm kiếm theo họ tên.\n"
                    + "3. Hiện thị thông tin về danh sách các cán bộ.\n"
                    + "4. Thoát khỏi chương trình.");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    searchByName();
                    break;
                case 3:
                    displayList();
                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }
        }

    }

    private static void displayList() {
        for (Employee employee : employeeList) {

            System.out.println(employee.toString());

        }
    }

    private static void searchByName() {
        System.out.println("Input name to find:");
        String nameFind = sc.nextLine();
        for (Employee employee : employeeList) {
            if (employee.getName().equals(nameFind)) {
                System.out.println(employee.toString());
            }
        }
    }

    private static void addEmployee() {
        System.out.println("Input name");
        String name = sc.nextLine();
        System.out.println("Input ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Input gender:");
        String gender = sc.nextLine();
        System.out.println("Input address");
        String address = sc.nextLine();
        System.out.println("Choose type employee: \n"
                + "1. Engineer\n"
                + "2. Staff\n"
                + "3. Worker");
        Employee employee = null;
        int key = Integer.parseInt(sc.nextLine());
        switch (key) {
            case 1:
                System.out.println("Input major:");
                String major = sc.nextLine();
                employee = new Engineer(name, age, gender, address, major);
                break;
            case 2:
                System.out.println("Input job:");
                String job = sc.nextLine();
                employee = new Staff(name, age, gender, address, job);
                break;
            case 3:
                System.out.println("Input level:");
                int level = Integer.parseInt(sc.nextLine());
                employee = new Worker(name, age, gender, address, level);
                break;
            default:
                break;
        }
        employeeList.add(employee);
    }
}
