import java.util.Scanner;

public class bai5 {
//     Write a java program to check type of 
//     student like with bad student with mark < 4.0, 
//     medium student with 4.0<= mark < 7, 
//     normal student with 7.0 <= mark < 8.0 and
// good student with 8.0<= mark <= 10,
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input mark of student: ");
        double mark = sc.nextDouble();
        if (mark < 4.0 && mark > 0) {
            System.out.println("Bad student");
        } else if (mark >= 4.0 && mark < 7) {
            System.out.println("medium student");
        } else if (mark >= 7 && mark < 8) {
            System.out.println("Normal student");
        } else if (mark >= 8 && mark <= 10) {
            System.out.println("good student");
        } else {
            System.out.println("Wrong mark");
        }
    }
}
