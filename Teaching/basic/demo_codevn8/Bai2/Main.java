import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("----MENU----\n"
                    + "1. Add\n"
                    + "2. Search\n"
                    + "3. Sort by name\n"
                    + "4. exit");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addNewUser();
                    break;
                case 2:
                    searchUser();
                    continue;
                case 3:
                    sortUser();
                    break;
                default:
                    return;
            }
            for (User user : userList) {
                user.display();
            }
        }

    }

    private static void sortUser() {
        Collections.sort(userList);
    }

    private static void searchUser() {
        System.out.println("Input id to search:");
        int id = Integer.parseInt(sc.nextLine());
        boolean flag = false;
        for (User user : userList) {
            if (user.getId() == id) {
                user.display();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Don't have element with that id");
        }
    }

    private static void addNewUser() {
        System.out.println("Input id: ");
        int id = userList.size()+1;
        System.out.println("Input name: ");
        String name = sc.nextLine();
        System.out.println("Input dateOfBirth: ");
        String dateOfBirth = sc.nextLine();
        System.out.println("Input gender: ");
        String gender = sc.nextLine();
        System.out.println("Input address: ");
        String address = sc.nextLine();
        System.out.println("Input phone: ");
        String phone = sc.nextLine();
        System.out.println("Input email: ");
        String email = sc.nextLine();
        User user = new User(id, name, dateOfBirth, gender, address, phone, email);
        userList.add(user);
        System.out.println("Add success");
    }
}
