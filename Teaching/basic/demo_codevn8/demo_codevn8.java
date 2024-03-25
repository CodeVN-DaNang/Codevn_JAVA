import java.util.Scanner;

public class demo_codevn8 {
    static Scanner sc = new Scanner(System.in);
    static String words = "qwertyuiopasdfghjklxcvbnm";

    public static void main(String[] args) {
        String str = sc.nextLine();
        // if (checkSymmetry(str)) {
        //     System.out.println("Symmetry");
        // }
        countAmountDigit(str);
    }

    // kiem tra doi xung
    public static boolean checkSymmetry(String checkStr){
        for (int i = 0; i < checkStr.length()/2; i++) {
            if(checkStr.charAt(i) != checkStr.charAt(checkStr.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    // co bao nhieu ky tu khac nhau
    // abcdefghiklmn...
    // abcdaaaeaa
    // abcde
    public static void countDigit(String checkStr){
        String result = "";
        for (int i = 0; i < words.length(); i++) {
            for (int j = 0; j < checkStr.length(); j++) {
                if (words.charAt(i) == checkStr.charAt(j) ) {
                    result += words.charAt(i);
                    break;
                }
            }
            
        }
        System.out.println(result.length());
    }

    // dem so luong moi ky tu khac nhau
    // abcdefghiklmn....
    // abcdaaeeccbb
    public static void countAmountDigit(String checkStr){
        for (int i = 0; i < words.length(); i++) {
            int count = 0;
            for (int j = 0; j < checkStr.length(); j++) {
                if (words.charAt(i) == checkStr.charAt(j) ) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println(words.charAt(i) + " xuat hien " + count);
            }
        }
    }

}
