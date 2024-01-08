import java.util.Scanner;

/**
 * demo_manh
 */
public class demo_manh {
    public static void main(String[] args) {
        // chuyen tu he co so 16 sang 10
        // ABCD = A * 16^3 (4-1) + B * 16^2 (n-1-i) + C * 16^1 + D * 16^0 
        // cach 1:
        // String[] words = {"A", "B", "C", "D"};
        Scanner sc = new Scanner(System.in);
        // String a = sc.nextLine(); // A1B3C8
        // String[] b = a.split(""); // {"A", 1, B, 3, C, 8}
        // int decimal = 0;
        // for (int i = 0; i < b.length; i++) { // b[0]=A  i= 0; 
        //     int count = -1;
        //     for (int j = 0; j < words.length; j++) { // words[j] = 
        //         if (b[i].equals(words[j])) {
        //             count = 10 + j;
        //         }
        //     }
        //     if (count == -1) {
        //         count = Integer.parseInt(b[i]);
        //     }
        //     decimal = decimal + count * (int) (Math.pow(16.0, (double) (b.length-1-i)));
        // }
        // System.out.println(decimal);

        // cach 2:
        // String words = "ABCD";
        // String a = sc.nextLine();
        // String[] b = a.split("");
        // int decimal = 0;
        // for (int i = 0; i < b.length; i++) {
        //     int count = 0;
        //     if (words.indexOf(b[i]) != -1) {
        //         count = 10 + words.indexOf(b[i]);
        //     } else {
        //         count = Integer.parseInt(b[i]);
        //     }
        //     decimal = decimal + count * (int) (Math.pow(16.0, (double) (b.length-1-i)));
        // }
        // System.out.println(decimal);
        
        System.out.println((int) 'B');
    } 
}