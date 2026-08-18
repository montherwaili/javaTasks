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
}