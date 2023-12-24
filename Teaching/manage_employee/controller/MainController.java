import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Employee;

public class MainController {
    // Thêm mới cán bộ.
    // Tìm kiếm theo họ tên.
    // Hiện thị thông tin về danh sách các cán bộ.
    // Thoát khỏi chương trình.
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Employee> employList = new ArrayList<>();
    
    public static void main(String[] args) {
        while (true) {
            displayMenu();
        }
    }

    public static void displayMenu(){
        System.out.println("----MANAGE EMPLOYEE----\n"
            + "1. Thêm mới cán bộ.\n" 
            + "2. Tìm kiếm theo họ tên.\n"
            + "3. Hiện thị thông tin về danh sách các cán bộ.\n"
            + "4. Thoát khỏi chương trình."
        );
        System.out.println("Enter your choice:");
        int n = Integer.parseInt(scanner.nextLine());
        switch (n) {
            case 1:
                addNewEmploy();
                break;
            case 2:
                findByName();
                break;
            case 3:
                displayAll();
                break;
            case 4:
                return;
            default:
                break;
        }
    }

    public static void addNewEmploy(){
        String bonusType = "abc";
        System.out.println("Nhap ten can bo muon add : ");
        String newNameCongNhan = scanner.nextLine();
        System.out.println("Nhap tuoi can bo : ");
        String newAgeCongNhan = scanner.nextLine();
        System.out.println("Nhap gioi tinh can bo : ");
        String newGenderCongnhan = scanner.nextLine();
        System.out.println("Nhap dia chi can bo : ");
        String newAdderessCongNhan = scanner.nextLine();
        

        System.out.println("Choose type of Employee:\n"
            + "1. Engineer\n"
            + "2. Worker\n"
            + "3. Staff"
        );
        int n = Integer.parseInt(scanner.nextLine());
        switch (n) {
            case 1:
                System.out.println("Nhap nganh cua ky su : ");
                bonusType = scanner.nextLine();
                Engineer engineer = new Engineer(newNameCongNhan, newAgeCongNhan, newGenderCongnhan, newAdderessCongNhan, bonusType);
                // employList.add(engineer);
                break;
            case 2:
                System.out.println("Nhap cap do cua cong nhan : ");
                int level = Integer.parseInt(scanner.nextLine());
                while (level < 0 || level >10) {
                    System.out.println("Ban phai nhap so trong khoang 1-10");
                    level = Integer.parseInt(scanner.nextLine());
                }
                Worker worker = new Worker(newAdderessCongNhan, newAgeCongNhan, newGenderCongnhan, bonusType, level);
                // employList.add(worker);
                break;
            case 3:
                System.out.println("Nhap cong viec cua nhan vien : ");
                bonusType = scanner.nextLine();
                Staff staff = new Staff(newNameCongNhan, newAgeCongNhan, newGenderCongnhan, newAdderessCongNhan, bonusType);
                // employList.add(staff);
                break;
            default:
                break;
        }

    }

    public static void findByName(){
        System.out.println("Nhap ten ban can tim:");
        String newName = scanner.nextLine();
        for (int i = 0; i < employList.size(); i++) {
            if (employList.get(i).getNameEmployee().contains(newName)) {
                System.out.println(employList.get(i).toString());
            }
        }
    }

    public static void displayAll(){
        for (int i = 0; i < employList.size(); i++) {
            System.out.println(employList.get(i).toString());
        }
    }

    
}
