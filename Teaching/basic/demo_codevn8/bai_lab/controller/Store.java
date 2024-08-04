package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import model.OfficeStaff;
import model.PartTimeStaff;
import model.Staff;

public class Store {

    Scanner sc = new Scanner(System.in);
    ArrayList<Staff> staffList = new ArrayList<>();

    public void avgEachStaff() {
        double totalSalaryOffice = 0;
        int amountOffice = 0;
        double totalSalaryPartime = 0;
        int amountPartime = 0;
        for (Staff staff : staffList) {
            if (staff.toString().contains("OfficeStaff")) {
                totalSalaryOffice += staff.getSalary();
                amountOffice++;
            }
            if (staff.toString().contains("PartTimeStaff")) {
                totalSalaryPartime += staff.getSalary();
                amountPartime++;
            }
        }
        System.out.println("Avg office: " + (totalSalaryOffice / (double) amountOffice));
        System.out.println("Avg parttime: " + (totalSalaryPartime / (double) amountPartime));
    }

    public void delete() {
        System.out.println("Input id to delete:");
        int id = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (Staff staff : staffList) {
            if (staff.getStaff_id() == id) {
                staffList.remove(count);
            }
            count++;
        }
    }

    public void search() {
        System.out.println("Input name to find:");
        String name = sc.nextLine();
        for (Staff staff : staffList) {
            if (staff.getStaff_name().equals(name)) {
                System.out.println(staff.toString());
            }

        }
    }

    public void sort() {
        Collections.sort(staffList);
        displayAll();
    }

    public void displayAll() {
        for (Staff staff : staffList) {
            System.out.println(staff.toString());
        }
    }

    public void addNewStaff() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Input type employee | 1-Parttime | 2-Fulltime");
        int type = Integer.parseInt(sc.nextLine());

        System.out.println("Input id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Input name: ");
        String name = sc.nextLine();
        System.out.println("Input age: ");
        int age = Integer.parseInt(sc.nextLine());

        Date birthDate = null;
        while (birthDate == null) {
            System.out.println("Input birth date (dd/MM/yyyy): ");
            String birthdateString = sc.nextLine();
            try {
                birthDate = dateFormat.parse(birthdateString);
            } catch (Exception e) {
                System.out.println("Invalid.");
            }
        }
        System.out.println("Input day of work: ");
        int dayOfWork = Integer.parseInt(sc.nextLine());
        Staff staff = null;
        if (type == 1) {
            System.out.println("Input discount:");
            double discount = Double.parseDouble(sc.nextLine());
            staff = new PartTimeStaff(id, name, age, birthDate, dayOfWork, 0.00, discount);
        } else if (type == 2) {
            System.out.println("Input OT Hours:");
            int OTHours = Integer.parseInt(sc.nextLine());
            staff = new OfficeStaff(id, name, age, birthDate, dayOfWork, 0.00, OTHours);
        }
        staffList.add(staff);
    }

}
