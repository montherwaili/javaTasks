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
}