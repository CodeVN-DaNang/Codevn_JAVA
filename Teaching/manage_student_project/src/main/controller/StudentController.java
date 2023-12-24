package main.controller;

import java.util.ArrayList;
import java.util.Scanner;

import main.model.entity.ClasS;
import main.model.entity.Student;
import main.model.service.ClassService.ClassService;
import main.model.service.StudentService.StudentService;

public class StudentController {
    ArrayList<Student> students = new ArrayList<>();
    StudentService studentService = new StudentService();
    ClassService classService = new ClassService();

    public void displayStudentMenu() {
        while (true) {
            students = studentService.findAllStudents();
            System.out.println("----MENU CLASS----\n"
                    + "1. display all classes.\n"
                    + "2. search\n"
                    + "3. add new class\n"
                    + "4. delete class\n"
                    + "5. edit class\n"
                    + "6. back to main menu");
            Scanner sc = new Scanner(System.in);
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    findAllStudents();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    addNewStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    updateStudent();
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }

    private void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input id Student:");
        int studentId = Integer.parseInt(sc.nextLine());
        Student student = studentService.findStudentById(studentId);
        if (student != null) {
            System.out.println("Input name Student:");
            String nameStudent = sc.nextLine();
            if (nameStudent == "") {
                nameStudent = student.getNameStudent();
            }
            System.out.println("Input address Student:");
            String address = sc.nextLine();
            if (address == "") {
                address = student.getAddress();
            }
            System.out.println("Input phone Student:");
            String phone = sc.nextLine();
            if (phone == "") {
                phone = student.getPhone();
            }
            System.out.println("status Student:\n"
                    + "1. true\n"
                    + "2. false");
            int key = Integer.parseInt(sc.nextLine());
            boolean status = student.isStatus();
            if (key == 1) {
                status = true;
            }
            System.out.println("Input id class:");
            int classId = Integer.parseInt(sc.nextLine());
            ClasS newClass = classService.findClassById(classId);
            if (newClass == null) {
                newClass = student.getClassId();
            }
            Student newStudent = new Student(nameStudent, address, phone, status, newClass);
            if (studentService.updateStudent(newStudent)) {
                System.out.println("Update sucess ^_^...");
            } else {
                System.out.println("Update fail T_T...");
            }
        }
    }

    private void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input id Student:");
        int studentId = Integer.parseInt(sc.nextLine());
        if (studentService.deleteStudent(studentId)) {
            System.out.println("Delete sucess ^_^...");
        } else {
            System.out.println("Dekete fail T_T...");
        }
    }

    private void addNewStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name Student:");
        String nameStudent = sc.nextLine();
        System.out.println("Input address Student:");
        String address = sc.nextLine();
        System.out.println("Input phone Student:");
        String phone = sc.nextLine();
        System.out.println("status Student:\n"
                + "1. true\n"
                + "2. false");
        int key = Integer.parseInt(sc.nextLine());
        boolean status = false;
        if (key == 1) {
            status = true;
        }
        System.out.println("Input id class:");
        int classId = Integer.parseInt(sc.nextLine());
        ClasS newClass = classService.findClassById(classId);
        Student newStudent = new Student(nameStudent, address, phone, status, newClass);
        if (studentService.addNewStudent(newStudent)) {
            System.out.println("Add sucess ^_^...");
        } else {
            System.out.println("Add fail T_T...");
        }

    }

    private ArrayList<Student> searchStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the name to search:");
        String nameStudent = sc.nextLine();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getNameStudent().contains(nameStudent)) {
                Student student = studentService.findStudentById(students.get(i).getIdStudent());
                System.out.println(student.toString());
                students.add(student);
            }
        }
        return students;
    }

    private void findAllStudents() {
        if (students.size() > 0) {
            for (Student student : students) {
                System.out.println(student.toString());
            }
        } else {
            System.out.println("404-Khong tim thay duoc du lieu");
        }

    }
}
