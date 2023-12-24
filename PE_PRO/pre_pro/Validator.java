/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author vannhat
 */
public class Validator {
    public static String patternName = "[A-Z][a-z]{1,}( [A-Z][a-z]{1,}){1,}";
    public static String patternDate = "^\\d{2}/\\d{2}/\\d{4}$";
    public static String patternId = "DE170[0-9]{3}";
    public static String patternOnlyNumber = "^\\d+$";
    public static String patternDoubleNumber = "^[-+]?\\d*\\.?\\d+$";
    
    public static boolean checkValid(String partternStr, String input){
        Pattern pattern = Pattern.compile(partternStr);
        Matcher check = pattern.matcher(input);
        return check.matches();
    }
    
}