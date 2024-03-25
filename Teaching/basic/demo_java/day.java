import java.util.Scanner;

/**
 * day
 */
public class day {

    // 7. Write a Java program to find the number of days in a month.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = 31;
        int month = sc.nextInt();
        
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            case 2:
                int year = sc.nextInt();
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    day = 29;
                    break;
                } 
                day = 28;
                break;
            default:
                break;
        }
        System.out.println("have " + day);
    }
}