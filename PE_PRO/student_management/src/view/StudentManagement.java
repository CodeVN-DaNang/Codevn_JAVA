/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.StudentList;
import java.util.Scanner;
import model.Student;

/**
 *
 * @author vannhat
 */
public class StudentManagement extends Menu<Student> {
    Scanner sc = new Scanner(System.in);
    StudentList studentList = new StudentList();
    
    public StudentManagement(String td, String[] mc) {
        super(td, mc);
    }
    
    public static void main(String[] args) {
        String mChon[] = {"list all", "add new student", "search student", "write to file", "exit"};
        StudentManagement studentManagement = new StudentManagement("MAIN MENU", mChon);
        studentManagement.run();
    }
    
    @Override
    public void execute(int n){
        switch(n){
            case 1:
                studentList.listAllStudent();
                break;
            case 2:
                studentList.addNewStudent();
                break;
            case 3:
                String mChon[] = {"search by id", "search by name", "search by date of birth" , "search by gender"};
                Menu searchMenu = new Menu("Search MENU", mChon){
                    @Override
                    public void execute(int n){
                        String criteria = sc.nextLine();
                        switch(n){
                            case 1:
                                studentList.search(p -> p.getStudentId().equalsIgnoreCase(criteria));
                                break;
                            case 2:
                                studentList.search(p -> p.getFirstName().equalsIgnoreCase(criteria));
                                studentList.search(p -> p.getLastName().equalsIgnoreCase(criteria));
                                break;
                            case 3:
                                studentList.search(p -> p.getDateOfBirth().equals(criteria));
                                break;
                            case 4:
                                studentList.search(p -> p.getGender().equalsIgnoreCase(criteria));
                                break;
                            case 5:
                                System.exit(0);
                        }
                    }
                };
                searchMenu.run();
                break;
            case 4:
                studentList.writeFile();
                break;
            case 5:
                System.exit(0);
        }
    }
}
