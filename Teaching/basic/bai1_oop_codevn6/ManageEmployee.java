import java.util.ArrayList;
import java.util.Scanner;

public class ManageEmployee {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Th\u00EAm m\u1EDBi c\u00E1n b\u1ED9.\n" + //
                    "2. T\u00ECm ki\u1EBFm theo h\u1ECD t\u00EAn.\n" + //
                    "3. Hi\u1EC7n th\u1ECB th\u00F4ng tin v\u1EC1 danh s\u00E1ch c\u00E1c c\u00E1n b\u1ED9.\n" + //
                    "4. Tho\u00E1t kh\u1ECFi ch\u01B0\u01A1ng tr\u00ECnh.");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    displayInforList();
                    break;
                default:
                    return;
            }
        }
    }

    private static void displayInforList() {
        for (Employee employee : employeeList) {
            System.out.println(employee.displayInfor());
        }
    }

    private static void searchEmployee() {
        System.out.println("Input name employee to search:");
        String name = sc.nextLine();
        for (Employee employee : employeeList) {
            if (employee.getName().contains(name)) {
                System.out.println(employee.displayInfor());
            }
        }
    }

    private static void addNewEmployee() {
        // Họ tên, tuổi, giới tính(nam, nữ, khác), địa chỉ.
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input age:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Input gender:");
        String gender = sc.nextLine();
        System.out.println("Input address:");
        String address = sc.nextLine();
        System.out.println("Choose type of employee:\n"
                + "1. Worker\n"
                + "2. Engineer\n"
                + "3. Staff");
        int key = Integer.parseInt(sc.nextLine());
        switch (key) {
            case 1: {
                System.out.println("Input level:");
                int level = Integer.parseInt(sc.nextLine());
                Employee newEmployee = new Worker(name, age, gender, address, level);
                employeeList.add(newEmployee);
                
                break;
            }
            case 2: {
                System.out.println("Input major training:");
                String majorTraining = sc.nextLine();
                Employee newEmployee = new Engineer(name, age, gender, address, majorTraining);
                employeeList.add(newEmployee);
                break;
            }
            case 3: {
                System.out.println("Input work job:");
                String workJob = sc.nextLine();
                Employee newEmployee = new Staff(name, age, gender, address, workJob);
                employeeList.add(newEmployee);
                break;
            }
            default:
                break;
        }

    }
}
