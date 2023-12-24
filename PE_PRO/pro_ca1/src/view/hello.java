/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author vannhat
 */
public class hello {

    public static void main(String[] args) {
        String mChon[] = {"list all employee", "calculate money", "sorting employee", "search employee", "exit"};
        EmployeeManagementSystem ems = new EmployeeManagementSystem("Employee Management System", mChon);
        ems.run();
    }
}
