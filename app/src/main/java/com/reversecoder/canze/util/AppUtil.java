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

    public static boolean isAlphaNumericNumber(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        String regexAtLeastOneLetter = ".*[A-Za-z].*";
        String regexAtLeastOneNumber = ".*[0-9].*";
        String regexOnlyNumberAndLetter = "[A-Za-z0-9]*";

        if (str.matches(regexAtLeastOneLetter) && str.matches(regexAtLeastOneNumber) && str.matches(regexOnlyNumberAndLetter)) {
            return true;
        } else {
            return false;
        }
    }

    public static int convertHexToDecimal(String str) {

        int result = -1;
        if (str != null || str.length() > 0) {
            // length should be even number
            // otherwise its not a valid hex
            if (str.length() % 2 == 0) {
                result = Integer.parseInt(str, 16);
            }
        }

        return result;
    }


}
