import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Thêm mới cán bộ.\n" + //
                    "2. Tìm kiếm theo họ tên.\n" + //
                    "3. Hiện thị thông tin về danh sách các cán bộ.\n" + //
                    "4. Thoát khỏi chương trình.");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    displayInfor();
                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    private static void displayInfor() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    private static void search() {
        System.out.println("Enter name to search: ");
        String nameSearch = sc.nextLine();
        for (Employee employee : employeeList) {
            if (employee.getName().contains(nameSearch)) {
                System.out.println(employee.toString());
            }
        }
    }

    static boolean addNewEmployee() {
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Enter gender: ");
        String gender = sc.nextLine();
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        Employee employee = new Employee();
        System.out.println("Choose type of employee: \n"
                + "1. Worker\n"
                + "2. Engineer\n"
                + "3. Staff");
        int key = Integer.parseInt(sc.nextLine());
        switch (key) {
            case 1:
                System.out.println("Enter level: ");
                int level = Integer.parseInt(sc.nextLine());
                employee = new Worker(name, age, gender, address, level);
                break;
            case 2:
                System.out.println("Enter major: ");
                String major = sc.nextLine();
                employee = new Engineer(name, age, gender, address, major);
                break;
            case 3:
                System.out.println("Enter staff: ");
                String job = sc.nextLine();
                employee = new Staff(name, age, gender, address, job);
                break;
            default:
                break;
        }
        return employeeList.add(employee);  
    }

}
