package exercise_lab;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> studentList = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("--------MANAGE STUDENT--------\n"
            + "1. Create student.\n"
            + "2. Average student.\n"
            + "3. Get percent type student.\n"
            + "4. Exit."
        );

        int i = Integer.parseInt(scanner.nextLine());
        switch(i){
            case 1:
                System.out.println(createStudent());
                break;
            case 2:
                findStudent();
                break;
            case 3:
                getPercentTypeStudent();

        }
    }

    private static double calculatePercent(String check){
        int count = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getTypeStudent().equals(check)){
                count++;
            }
        }
        return count/findStudent().size();
    }

    private static void getPercentTypeStudent() {
        System.out.println("----Classification infor----"
            + "A: " + calculatePercent("A")
            + "B: " + calculatePercent("B")
            + "C: " + calculatePercent("C")
            + "D: " + calculatePercent("D")
        );
    }


    private static ArrayList<Student> findStudent() {
        ArrayList<Student> findStudents = new ArrayList<>();
        System.out.println("Nhap ten muon tim:");
        String findString = scanner.nextLine();
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getName().contains(findString)){
                System.out.println("----STUDENT INFOR----\n"
                    + "Name: " + studentList.get(i).getName()
                    + "Classes: " + studentList.get(i).getClassName()
                    + "AVG: " + studentList.get(i).getAvg()
                    + "Type: " + studentList.get(i).getTypeStudent()
                );
                findStudents.add(studentList.get(i));
            } 
        }
        return findStudents;
    }


    private static boolean createStudent() {
        System.out.println("Nhap ten:");
        String name = scanner.nextLine();

        System.out.println("Nhap ten lop:");
        String className = scanner.nextLine();
        System.out.println("Nhap toan:");
        double math = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap ly:");
        double physic = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap hoa:");
        double chemis = Double.parseDouble(scanner.nextLine());        
        
        Student student = new Student(name, className, math, physic, chemis );
        studentList.add(student);
        return true;

    }

}
