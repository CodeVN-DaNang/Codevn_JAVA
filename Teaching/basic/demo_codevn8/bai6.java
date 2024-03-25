import java.util.Scanner;

public class bai6 {
    // giai pt bac 2 -> nguoi dung can nhap vao cai gi : ax^2 + bx + c = 0
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);       
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int delta = b*b - 4*a*c;
        if (delta < 0) {
            System.out.println("Phuong trinh vo nghiem");
        } else if (delta == 0) {
            double x = (double) -b/(2*a);
            System.out.println("Phuong trinh co 1 nghiem duy nhat la: " + x);
        } else {
            double x1 = (double) (-b + Math.sqrt(delta)) / (2*a);
            double x2 = (double) (-b - Math.sqrt(delta)) / (2*a);
            System.out.println("Phuong trinh co 2 nghiem la x1 = " + x1 + " va x2 = " + x2);
        }

    }
}
