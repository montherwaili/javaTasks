package utils;

import java.util.List;

// static = ready to use without making an object
public class HelperUtils {

    private static int counter = 1;   // simple id counter

    // ---- isEmpty (overloaded) ----
    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
    // ---- isValidString (overloaded x3) ----
    public static boolean isValidString(String s) {
        return !isEmpty(s);
    }
    public static boolean isValidString(String s, int minLength) {
        return !isEmpty(s) && s.trim().length() >= minLength;
    }
    public static boolean isValidString(String s, int min, int max) {
        return !isEmpty(s) && s.trim().length() >= min && s.trim().length() <= max;
    }
    // ---- generateId (overloaded) ----
    public static String generateId() {
        return "ID-" + (counter++);
    }
    public static String generateId(String prefix) {
        return prefix + "-" + (counter++);
    }
    // ---- isPositive (overloaded) ----
    public static boolean isPositive(int n) {
        return n > 0;
    }
    public static boolean isPositive(double n) {
        return n > 0;
    }

    // ---- isValidNumber (overloaded) ----
    public static boolean isValidNumber(int n, int min, int max) {
        return n >= min && n <= max;
    }
    public static boolean isValidNumber(double n, double min, double max) {
        return n >= min && n <= max;
    }

    // ---- isValidAge ----
    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 120;
    }
}