import java.util.Scanner;

public class bai4 {
    // Write a java program to check whether an
    // alphabet is a vowel or consonant.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        // if (word.equals("u") || word == "e" || word == "o" || word == "a" || word ==
        // "i" ) {
        // System.out.println(word + " is vowel");
        // } else {
        // System.out.println(word + " is corsonant");
        // }
        switch (word) {
            case "u":
            case "e":
            case "o":
            case "a":
            case "i":
                System.out.println(word + " is vowel");
                break;
            default:
                System.out.println(word + " is corsonant");
                break;
        }
    }
}
