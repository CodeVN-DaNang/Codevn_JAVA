import java.util.Random;
import java.util.Scanner;

public class BaiRand {
    // nhap vao 2 mang tron 2 mang va sap xep
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // nhap mang
        System.out.println("Input length of arr1:");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Input length of arr2:");
        n = sc.nextInt();
        int[] arr2 = new int[n];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }
        // tron mang
        int[] arr3 = new int[arr1.length + arr2.length];
        int[] indexOfArr3 = new int[arr3.length]; // [3,0,0,0,0,0,0,0,0,0]
        // rand vi tri trong mang arr3
        int count = 0;
        while (count < arr3.length) {
            System.out.println("hello");
            Random random = new Random();
            int num = random.nextInt(count + 1);
            boolean flag = true;
            for (int i = 0; i < indexOfArr3.length; i++) {
                if (indexOfArr3[i] == num) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                indexOfArr3[count] = num;
                count++;
            }
        }
        for (int i = 0; i < arr3.length; i++) {
            if(i < arr1.length){
                arr3[i] = arr1[indexOfArr3[i]];
            } else {
                arr3[i] = arr2[indexOfArr3[i-arr1.length]];
            }
            
        }
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3);
        }

    }

}
