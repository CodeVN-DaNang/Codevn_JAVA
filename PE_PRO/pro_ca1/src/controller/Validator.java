/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vannhat
 */
public class Validator {
    public static String patternDate = "^\\d{2}/\\d{2}/\\d{4}$";
    public static String patternDoubleNumber = "^[-+]?\\d*\\.?\\d+$";
    public static String patternAccount = "[A-Z][a-z]{1,}[A-Z]{1,}";
    public static String patternId = "MNV[0-9]{3,}";
    
    public static boolean checkValid(String patternStr, String input){
        Pattern pattern = Pattern.compile(patternStr);
        Matcher check = pattern.matcher(input);
        return check.matches();
    }
    
}
