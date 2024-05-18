import java.util.Scanner;

public class test_function {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        int c = sc.nextInt();
        int d = sc.nextInt();
        int a = sum(d, c);
        // System.out.println(sum(c, d));
        display(a);
    }

    public static int sum(int a, int b){
        
        return a + b;
    }

    public static void display(int a){
        
        if (a > 0) {
            System.out.println(a);
            return;
        }
        System.out.println("Khong co gi het");
    }

}
