package controller;

import java.util.Scanner;

import model.entity.BorrowCard;
import model.entity.Student;
import model.service.BorrowCardService;
import model.service.StudentService;

public class MainController {
    static BorrowCardService borrowCardService = new BorrowCardService();
    static StudentService studentService = new StudentService();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("MENU\n"
                    + "1. Add new borrow\n"
                    + "2. delete borrow\n"
                    + "3. display all card\n"
                    + "4. exit");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addNewBorrowCard();
                    break;
                case 2:
                    deleteBorrow();
                    break;
                case 3:
                    displayAllCard();
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }

    }

    private static void displayAllCard() {
        int i = 0;
        for (BorrowCard borrowCard : borrowCardService.getAllCards()) {
            System.out.println(++i + ". " + borrowCard.toString());
        }
    }

    private static void deleteBorrow() {
        System.out.println("Input index of card to delete: ");
        int index = Integer.parseInt(sc.nextLine());
        borrowCardService.deleteCard(index);
    }

    // product co thuoc tinh la TypeProduct(nuoc ngot, nuoc loc, bia, tra, tra sua)

    private static void addNewBorrowCard() {
        System.out.println("Input id ");
        String id = sc.nextLine();
        System.out.println("Input borrow date: ");
        String borrowDate = sc.nextLine();
        System.out.println("Input date expiration ");
        String dateExp = sc.nextLine();
        System.out.println("Input bookId ");
        String bookId = sc.nextLine();
        System.out.println("Choose a student from list of student:");
        int i = 0;
        for (Student student : studentService.getAllStudents()) {
            System.out.println(++i + ". " + student.toString());
        }
        System.out.println("If dont have you can choose '0':");
        int index = Integer.parseInt(sc.nextLine());
        Student student;
        if (index == 0) {
            student = addNewStudent();
        } else {
            student = studentService.getStudentById(index - 1);
        }
        borrowCardService.addNewCard(new BorrowCard(id, borrowDate, dateExp, bookId, student));
    }

    private static Student addNewStudent() {
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input age:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Input class: ");
        String classes = sc.nextLine();
        studentService.addNewStudent(new Student(name, age, classes));
        return new Student(name, age, classes);
    }

}
