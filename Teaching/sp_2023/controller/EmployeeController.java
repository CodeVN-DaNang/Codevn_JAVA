package controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Doctor;
import model.Employee;
import model.Nurse;

public class EmployeeController {
    Scanner sc = new Scanner(System.in);
    ArrayList<Employee> employees = new ArrayList<>();

    public void displayEmployeeMenu() {
        int key = Integer.parseInt(sc.nextLine());
        switch (key) {
            case 1:
                addNewEmployee();
                break;
            case 2:
                displayAllEmployee();
                break;
            case 3:
                viewXamLol();
                break;
            case 4:
                findByName();
                break;
            case 5:
                System.exit(key);
            default:
                break;
        }
    }

    private void findByName() {
        System.out.println("Enter the name to find:");
        String name = sc.nextLine();
        displayEmployeeByType(name);
    }

    
    private void viewXamLol() {
        float salaryOfDoctor = 0;
        float salaryOfNurse = 0;
        for (Employee employee : employees) {
            if (employee.toString().contains("Doctor")) {
                salaryOfDoctor = salaryOfDoctor + employee.calculateSalary();
            } else {
                salaryOfNurse = salaryOfNurse + employee.calculateSalary();
            }
        }
        if (salaryOfDoctor > salaryOfNurse) {
            displayEmployeeByType("Doctor");
        } else {
            displayEmployeeByType("Nurse");
        }
        
    }

    private void displayAllEmployee() {
        System.out.println("What do you want to create?\n"
            + "1. Doctor.\n"
            + "2. Nurse.\n"
        );
        int key = Integer.parseInt(sc.nextLine());
        String find = "";
        switch (key) {
            case 1:
                find = "Doctor";
                break;
            case 2:
                find = "Nurse";
                break;
            default:
                break;
        }
        displayEmployeeByType(find);
    }

    public void displayEmployeeByType(String find) {
        for (Employee employee : employees) {
            if (employee.toString().contains(find)) {
                System.out.println(employee.toString());
            }
        }
    }

    public boolean checkMail(String email) {
        Pattern patternMail = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"); // regex
        Matcher matcher = patternMail.matcher(email);
        return matcher.matches();
    }

    public boolean checkPhone(String phone) {
        Pattern patternPhone = Pattern.compile("^\\d{10,}$");
        Matcher matcher = patternPhone.matcher(phone);
        return matcher.matches();
    }

    private void addNewEmployee() {
        System.out.println("Enter id employee:");
        int idEmployee = Integer.parseInt(sc.nextLine());
        System.out.println("Enter name employee:");
        String nameEmployee = sc.nextLine();
        System.out.println("Enter phone employee:");
        String phone = "";
        while (!checkPhone(phone)) {
            phone = sc.nextLine();
        }
        System.out.println("Enter email employee:");
        String email = "";
        while (!checkMail(email)) {
            email = sc.nextLine();
        }
        System.out.println("Enter coefficients salary:");
        float coefficientsSalary = Float.parseFloat(sc.nextLine());
        System.out.println("What do you want to create?\n"
            + "1. Doctor.\n"
            + "2. Nurse.\n"
        );
        int key = Integer.parseInt(sc.nextLine());
        switch (key) {
            case 1:
                System.out.println("Enter level employee:");
                int level = Integer.parseInt(sc.nextLine());
                System.out.println("Enter major employee:");
                String major = sc.nextLine();
                System.out.println("Enter position employee:");
                int position = Integer.parseInt(sc.nextLine());
                Doctor doctor = new Doctor(idEmployee, nameEmployee, phone, email, coefficientsSalary, level, major, position);
                employees.add(doctor);
                break;
            case 2:
                System.out.println("Enter overtime employee:");
                int overtime = Integer.parseInt(sc.nextLine());
                System.out.println("Enter department employee:");
                String department = sc.nextLine();
                Nurse nurse = new Nurse(idEmployee, nameEmployee, phone, email, coefficientsSalary, department, overtime);
                employees.add(nurse);
                break;
            default:
                break;
        }
    }
}
