import java.util.Scanner;

public class PT2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        printValue(a, b, c);
    }

    // tinh delta
    public static double calculateDelta(double a, double b, double c){
        double delta = 0;
        delta = b*b - 4*a*c;
        return delta;
    }

    // tinh nghiem va in nghiem
    public static void printValue(double a, double b, double c){
        double delta = calculateDelta(a, b, c);
        if (delta > 0) {
            double x1 = (-b - Math.sqrt(delta))/(2*a);
            double x2 = (-b + Math.sqrt(delta))/(2*a);
            System.out.println("pt co 2 nghiem: x1 = " + x1 + " va x2= " + x2);
        } else if (delta == 0) {
            double x = (-b)/(2*a);
            System.out.println("pt co 2 nghiem kep : " + x);
        } else {
            System.out.println("pt vo nghiem");
        }
    }
}
