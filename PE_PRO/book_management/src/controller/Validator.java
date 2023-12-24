/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static String patternId = "B[0-9]{4}";
    public static String patternName = "[A-Z][A-Za-z]{1,}( [A-Za-z][A-Za-z]{1,}){1,}";
    public static String patternAuthorName = "[A-Z][a-z]{1,}( [A-Z][a-z]{1,}){1,}";
    public static String patternYear = "[12][0-9]{3}";
    
    public static boolean checkValid(String patternStr, String input){
        Pattern pattern = Pattern.compile(patternStr);
        Matcher check = pattern.matcher(input);
        return check.matches();
    }
}
