package com.reversecoder.canze.util;

public class AppUtil {

    public static boolean isNullOrEmpty(String myString) {
        if (myString == null) {
            return true;
        }
        if (myString.length() == 0 || myString.equalsIgnoreCase("null")
                || myString.equalsIgnoreCase("")) {
            return true;
        }
        return false;
    }

    public static boolean isHexNumber(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        // length should be even number
        // otherwise its not a valid hex
        if (str.length() % 2 == 0) {
            String var1 = "(?i)[0-9a-f]+";
            return str.matches(var1);
        }

        return false;
    }


}
