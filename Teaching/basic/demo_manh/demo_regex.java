import java.util.Scanner;

public class demo_regex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regexName = "[A-Z][a-z]{1,}( [A-Z][a-z]{1,}){0,}";
        String regexEmail = "[A-Za-z0-9]{1,}@[a-z]{3,}.com";
        String regexPhone = "09[0-9]{8}";
        // String name = "";
        // do {
        //     System.out.println("Input name:");
        //     name = sc.nextLine();
        // }while (!name.matches(regexName));
        // String email = "";
        // do {
        //     System.out.println("Input email:");
        //     email = sc.nextLine();
        // }while (!email.matches(regexEmail));
        String phone = "";
        do {
            System.out.println("Input phone:");
            phone = sc.nextLine();
        }while (!phone.matches(regexPhone));
        System.out.println("success!!!");
    }
}
