package controller;

import java.util.Scanner;
import java.util.regex.Pattern;

import model.entities.User;
import model.service.UserService;

public class UserController {
    static UserService userService = new UserService();
    static Scanner sc = new Scanner(System.in);
    static Pattern checkUsername = Pattern.compile("^(?=.{5,}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$");
    static Pattern checkPassword = Pattern.compile("^(?=.{6,}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$");

    public static void main(String[] args) {
        while (true) {
            System.out.print("====== USER MANAGEMENT SYSTEM ======\r\n" + //
                    "1. Create a new account\r\n" + //
                    "2. Login system\r\n" + //
                    "3. Exit\r\n" + //
                    "> Choose: ");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    doLogin();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }

    private static void doLogin() {
        System.out.println("Enter username:");
        String username = " ";
        while (!checkUsername.matcher(username).matches()) {
            System.out.println("You must enter least at 5 character, and no space!");
            username = sc.nextLine();
        }
        System.out.println("Enter password:");
        String password = " ";
        while (!checkPassword.matcher(password).matches()) {
            System.out.println("You must enter least at 6 character, and no space!");
            password = sc.nextLine();
        }
        User user = new User(username, password);
        if (userService.doLogin(user)) {
            System.out.println("Login success");
        } else {
            System.out.println("Login failed");
        }
    }

    private static void createNewAccount() {
        System.out.println("Enter username:");
        String username = " ";
        while (!checkUsername.matcher(username).matches()) {
            System.out.println("You must enter least at 5 character, and no space!");
            username = sc.nextLine();
        }
        System.out.println("Enter password:");
        String password = " ";
        while (!checkPassword.matcher(password).matches()) {
            System.out.println("You must enter least at 6 character, and no space!");
            password = sc.nextLine();
        }
        User user = new User(username, password);
        if (userService.doRegister(user)) {
            System.out.println("Register success");
        } else {
            System.out.println("Username have existed");
        }
    }

}
