/**
 * Print20PrimeNum
 */
public class Print20PrimeNum {
    public static void main(String[] args) {
        int count = 0;
        int num = 2;
        while (count < 20) {
            boolean flag = true;
            if (num == 2) {
                System.out.println(num);
                num++;
                count++;
                continue;
            }
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
                System.out.println(num);
            }
            num++;
        }
    }
}