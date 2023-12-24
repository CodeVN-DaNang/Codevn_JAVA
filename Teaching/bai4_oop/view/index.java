package view;

import java.util.Scanner;

public class index {
    Scanner sc = new Scanner(System.in);
    public int display() {
        System.out.println("----MENU----\n"
            + "1. manage people\n"
            + "2. manage Bill"
        );
        int choose = Integer.parseInt(sc.nextLine());
        return choose;
    }
}
