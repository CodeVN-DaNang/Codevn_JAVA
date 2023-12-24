package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeValidate {
    static String dayParttern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
    public static boolean checkDay(String day){
        Pattern pt = Pattern.compile(dayParttern);
        Matcher dayMatcher = pt.matcher(day);
        return dayMatcher.matches();
    }
}
