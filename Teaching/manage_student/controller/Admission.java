package manage_student.controller;

import java.util.ArrayList;
import java.util.Scanner;

import manage_student.model.Major;
import manage_student.model.Student;


public class Admission {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> studentList = new ArrayList<>();

    public boolean addStudent(){
        System.out.println("Enter id:");
        String idStudent = scanner.nextLine();
        System.out.println("Enter name:");
        String nameStudent = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        System.out.println("Enter priority:");
        int priority = Integer.parseInt(scanner.nextLine());
        System.out.println("Choose major:\n"
            + "1. Major A\n"
            + "2. Major B\n"
            + "3. Major C\n"
        );
        int key = Integer.parseInt(scanner.nextLine());
        Major newMajor = new Major();
        switch (key) {
            case 1:
                Major majorA = new Major("1", "A1", "Math", "Physic", "Chemistry");
                newMajor = majorA;
                break;
            case 2:
                Major majorB = new Major("2", "B", "Math", "Chemistry", "Biology");
                newMajor = majorB;
                break;
            case 3:
                Major majorC = new Major("3", "C", "Literature", "History", "Geography");
                newMajor = majorC;
                break;
            default:
                break;
        }
        Student newStudent = new Student(idStudent, nameStudent, address, priority, newMajor);
        studentList.add(newStudent);
        return true;
    }

    public ArrayList<Student> findAllStudentById(){
        return studentList;
    }

    public void displayAllStudent(){
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).toString());
        }
    }

    public ArrayList<Student> findStudentById(String id){
        ArrayList<Student> newStudentList = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getIdStudent().contains(id)){
                newStudentList.add(studentList.get(i));
            }
        }
        return newStudentList;
    }

    public void displayStudent(){
        System.out.println("Enter id student to find:");
        String idStudent = scanner.nextLine();
        ArrayList<Student> studentListToFind = findStudentById(idStudent);
        for (int i = 0; i < studentListToFind.size(); i++) {
            System.out.println(studentListToFind.get(i).toString());
        }
    }



}
