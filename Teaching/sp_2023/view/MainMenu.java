package view;

import controller.EmployeeController;

public class MainMenu {
    static EmployeeController employeeController = new EmployeeController();
    public static void main(String[] args) {
        while (true) {
            System.out.println("----EMPLOYEE MENU----\n"
                + "1. add new employee\n"
                + "2. display employee by type\n"
                + "3. display employee by salary\n"
                + "4. display employee by name\n"
                + "5. Exit"
            );
            employeeController.displayEmployeeMenu();
        }
    }
}
