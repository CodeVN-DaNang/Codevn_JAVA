import java.util.Scanner;

import main.controller.ClassController;
import main.controller.StudentController;

public class App {
    static ClassController classController = new ClassController();
    static StudentController studentController = new StudentController();
    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("----MENU----\n"
                + "1. Manage Class\n"
                + "2. Manage Student"
            );
            Scanner scanner = new Scanner(System.in);    
            int key = Integer.parseInt(scanner.nextLine());
            switch (key) {
                case 1:
                    classController.displayClassMenu();
                    break;
                case 2:
                    studentController.displayStudentMenu();
                default:
                    break;
            }
        }
        
    }
}
