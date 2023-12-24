/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.EmployeeManagement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.Employee;

/**
 *
 * @author vannhat
 */
public class EmployeeManagementSystem extends Menu<Employee> {
    Scanner sc = new Scanner(System.in);
    EmployeeManagement eplManagement = new EmployeeManagement();

    public EmployeeManagementSystem(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                eplManagement.getAllEmployee();
                break;
            case 2:
                eplManagement.calculateMoney();
                break;
            case 3:
                eplManagement.sortEmployee();
                break;
            case 4:
                String mChonSearch[] = {"find by account", "find by working start date"};
                Menu searchMenu = new Menu("Employee searching", mChonSearch) {
                    @Override
                    public void execute(int n) {
                        switch(n){
                            case 1:
                                System.out.println("Input account to search");
                                String account = sc.nextLine();
                                eplManagement.search(p -> p.getAccount().equalsIgnoreCase(account));
                                break;
                            case 2:
                                System.out.println("Input date to search");
                                String date = sc.nextLine(); 
                                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate workStartingDate = LocalDate.parse(date, format);
                                eplManagement.search(p -> p.getWorkStartingDate().equals(workStartingDate));
                                break;
                        }
                    }
                };
                searchMenu.run();
                break;
            case 5:
                System.exit(n);
        }
    }

}
