import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Thêm mới cán bộ.\n" + //
                    "Tìm kiếm theo họ tên.\n" + //
                    "Hiện thị thông tin về danh sách các cán bộ.\n" + //
                    "Thoát khỏi chương trình.");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    searchByName();
                    break;
                case 3:
                    displayAll();
                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }
        }

    }

    private static void displayAll() {
        for (int i = 0; i < employeeList.size(); i++) {

            System.out.println(employeeList.get(i).toString());

        }
    }

    private static void searchByName() {
        System.out.println("Input name to search:");
        String name = sc.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getName().contains(name)) {
                System.out.println(employeeList.get(i).toString());
            }
        }
    }

    private static void addNewEmployee() {
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input age:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Input gender:");
        String gender = sc.nextLine();
        System.out.println("Input address:");
        String address = sc.nextLine();
        System.out.println("Choose:\n"
                + "1. Engineer\n"
                + "2. Staff\n"
                + "3. Worker");
        int key = Integer.parseInt(sc.nextLine());
        Employee employee = null;
        switch (key) {
            case 1:
                System.out.println("Input major:");
                String major = sc.nextLine();
                employee = new Engineer(name, age, gender, address, major);
                break;
            case 2:
                System.out.println("Input job:");
                String job = sc.nextLine();
                employee = new Staff(name, age, gender, address, job);
                break;
            case 3:
                System.out.println("Input level:");
                int level = Integer.parseInt(sc.nextLine());
                employee = new Worker(name, age, gender, address, level);
                break;
            default:
                break;
        }
        employeeList.add(employee);
    }
}
