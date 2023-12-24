package controller;

import java.util.Scanner;

import model.entity.ClasS;
import model.entity.Student;
import model.service.ClassService;
import model.service.StudentService;

public class StudentMain {
    static StudentService studentService = new StudentService();
    static ClassService clasService = new ClassService();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("----MENU----");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addNewStudent();
                    break;

                default:
                    displayAllStudents();
                    break;
            }
        }

    }

    private static void displayAllStudents() {
        for (Student student : studentService.getAllStudents()) {
            System.out.println(student.toString());
        }
    }

    private static void addNewStudent() {
        System.out.println("Input name Student:");
        String name = sc.nextLine();
        System.out.println("Input age Student:");
        String age = sc.nextLine();
        System.out.println("Input home town Student:");
        String town = sc.nextLine();
        System.out.println("Input class Student:");
        for (ClasS clasS : clasService.getAlClasSs()) {
            System.out.println(clasS.toString());
        }
        int indexClasS = Integer.parseInt(sc.nextLine());
        ClasS clasS = clasService.getClassById(indexClasS);
        Student student = new Student(name, age, town, clasS);
        studentService.addStudent(student);
    }

}
