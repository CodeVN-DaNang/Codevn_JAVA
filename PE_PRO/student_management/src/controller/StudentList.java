/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import model.Student;

/**
 *
 * @author vannhat
 */
public class StudentList {
    ArrayList<Student> studentList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

//+ Read text file to load data for StudentList – student.txt is provided (1 mark) 


    
    // List of Student
    public void listAllStudent(){
        if (studentList.isEmpty()) {
            // load file from txt
            readFile();
        }
        printList(studentList);
    }
    
    //+ Print any List of Student (1 mark)
    public void printList(ArrayList<Student> stdList){
        for (Student student : stdList) {
            System.out.println(student.toString());
        }
        System.out.println("Total of list: " + stdList.size());
    }
    
    // read file
    public void readFile(){
        try{
            FileReader fr = new FileReader("src/data/student.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while((line = br.readLine()) != null){
                String arr[] = line.split(",");
                String studentId = arr[0];
                String firstName = arr[1];
                String lastName = arr[2];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
                LocalDate dateOfBirth = LocalDate.parse(arr[3], formatter);
                String gender = arr[4];
                Student student = new Student(studentId, firstName, lastName, dateOfBirth, gender);
                studentList.add(student);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    // write file
    public void writeFile(){
        try{
            FileWriter fw = new FileWriter("src/data/student.txt");
            String line = "";
            for (Student student : studentList) {
                line += student.getStudentId() + "," +student.getFirstName()+"," + student.getLastName() + "," + student.getDateOfBirth() + "," +student.getGender() + "\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //+ Add new Student from console (1 mark)
    public void addNewStudent(){
        System.out.println("Input student id:");
        String studentId = sc.nextLine();
        System.out.println("Input student first name:");
        String firstName = sc.nextLine();
        System.out.println("Input student last name:");
        String lastName = sc.nextLine();
        System.out.println("Input student date of birth:");
        String inputDate  = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDate dateOfBirth = LocalDate.parse(inputDate, formatter);
        System.out.println("Input student gender:");
        String gender = sc.nextLine();
        Student student = new Student(studentId, firstName, lastName, dateOfBirth, gender);
        studentList.add(student);
    }
    
    //+ Search student by different criteria  (1 mark)
    public void search(Predicate<Student> p) {
        ArrayList<Student> findStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (p.test(student)) {
                findStudents.add(student);
            }
        }
        printList(findStudents);
    }

}
