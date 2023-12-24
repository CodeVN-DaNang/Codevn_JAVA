import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String email = "testexample.com";
        boolean isValid = validateEmail(email);
        if (isValid) {
            System.out.println("Valid email address!");
        } else {
            System.out.println("Invalid email address.");
        }
    }
    
    public static boolean validateEmail(String email) {
        String pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }
}
