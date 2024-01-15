import java.util.Scanner;

/**
 * SuperPrime
 */
public class SuperPrime {
    // if (isSuperPrime(i)) {
    // System.out.println(i + " is super prime number");
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = (int) Math.pow(10.0, (double) (number - 1)); i < (int) Math.pow(10.0, (double) number); i++) {
            int virNum = i;
            boolean flag = true;
            while (virNum > 0) {
                if (virNum < 2) {
                    flag = false;
                    break;
                } else if (virNum == 2) {
                    break;
                } else {
                    for (int j = 2; j < virNum / 2; j++) {
                        if (virNum % j == 0) {
                            flag = false;
                            break;
                        }
                    }
                }
                virNum = virNum / 10;
            }
            if (flag) {
                System.out.println(i + " is super prime number");
            }
        }

    }

    // kiem tra so sieu nguyen to

    // ham kiem tra so nguyen to
    public static boolean checkPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 2333 -> 233 -> 23 -> 2 -> 0
    public static int changeNum(int number) {
        return number / 10;
    }

    // ham kiem tra so
    public static boolean isSuperPrime(int number) {
        if (number < 10) {
            return false;
        }
        while (number > 0) {
            if (!checkPrime(number)) {
                return false;
            }
            number = changeNum(number);
        }
        return true;
    }
}