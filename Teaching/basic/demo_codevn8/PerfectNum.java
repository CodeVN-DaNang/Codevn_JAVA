import java.util.Scanner;

public class PerfectNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        for(int i = 1; i < num; i++){
            if (num % i == 0) {
                // sum += i;
                sum = sum + i;
            }
        }
        if (sum == num) {
            System.out.println("Number " + num + " is a perfect number");
        } else {
            System.out.println("Number " + num + " is not a perfect number");
        }
    }
}
