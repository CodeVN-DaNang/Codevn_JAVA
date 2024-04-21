import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        // Nhap vao 1 so kiem tra so do la chan hay le
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        int a = sc.nextInt();
        if (a % 2 == 0) {
            System.out.print(a + ", " + a + " la so chan");
        } else {
            System.out.println(a + " la so le");
        }
    }
}
