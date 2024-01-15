import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        // nhap 1 so kiem tra so do chan hay le
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println(num + " la so chan");
        } else {
            System.out.println(num + " la so le");
        }
    }
}