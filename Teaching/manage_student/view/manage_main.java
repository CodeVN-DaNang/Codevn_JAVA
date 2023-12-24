package manage_student.view;

import java.util.Scanner;

import manage_student.controller.Admission;

public class manage_main {
    static Scanner scanner = new Scanner(System.in);
    static Admission admission = new Admission();

    public static void main(String[] args) {
        while (true) {
            System.out.println("----MENU----\n"
                    + "1. add new student.\n"
                    + "2. show all students.\n"
                    + "3. show student.\n"
                    + "4. exit.\n");
            int key = Integer.parseInt(scanner.nextLine());
            switch (key) {
                case 1:
                    admission.addStudent();
                    break;
                case 2:
                    admission.displayAllStudent();
                    break;
                case 3:
                    admission.displayStudent();
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }

    }
}
