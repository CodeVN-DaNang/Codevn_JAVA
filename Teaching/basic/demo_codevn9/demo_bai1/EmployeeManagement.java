import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("MENU\n"
                    + "1. Add new employee\n"
                    + "2. Search by name\n"
                    + "3. Display all employee\n"
                    + "4. Exit");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    add();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Thank for using my app");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }

    private static void display() {
        for (Employee employee : employeeList) {
            System.out.println(employee.displayInfor());
        }
    }

    private static void search() {
        System.out.println("Input name to search:");
        String name = sc.nextLine();
        for (Employee employee : employeeList) {
            if (employee.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(employee.displayInfor());
            }
        }
    }

    private static void add() {
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input age:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Input gender:");
        String gender = sc.nextLine();
        System.out.println("Input address");
        String address = sc.nextLine();
        System.out.println("Type of employee:\n"
                + "1. Worker\n"
                + "2. Engineer\n"
                + "3. Staff");
        int choose = Integer.parseInt(sc.nextLine());
        Employee employee = new Employee();
        switch (choose) {
            case 1:
                System.out.println("Input level");
                int level = Integer.parseInt(sc.nextLine());
                employee = new Worker(name, age, gender, address, level);
                break;
            case 2:
                System.out.println("Input major");
                String major = sc.nextLine();
                employee = new Engineer(name, age, gender, address, major);
                break;
            case 3:
                System.out.println("Input job");
                String job = sc.nextLine();
                employee = new Staff(name, age, gender, address, job);
                break;
            default:
                break;
        }
        employeeList.add(employee);
    }
}
