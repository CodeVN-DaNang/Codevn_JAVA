import java.util.Scanner;

public class DemoLoop {
    public static void main(String[] args) {
        // so nguyen to la so chi chia het cho 1 và chính nó
        // số 15 -> 2 -> 14
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number to check prime number: ");
        int num = sc.nextInt();
        boolean flag = true;
        if (num <= 1) {
            flag = false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(num + " is prime number");
        } else {
            System.out.println(num + " is not a prime number");
        }
    }
}
