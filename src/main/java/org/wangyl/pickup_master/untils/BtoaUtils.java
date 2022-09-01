package org.wangyl.pickup_master.untils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BtoaUtils {
    public static boolean isMatcher(String inStr, String reg) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(inStr);
        return matcher.matches();
    }

    public static String btoa(String inStr) {
        if (inStr == null || isMatcher(inStr, "([^\\u0000-\\u00ff])")) {
            throw new Error("INVALID_CHARACTER_ERROR");
        }
        StringBuilder result = new StringBuilder();
        int i = 0, mod = 0, ascii, prev = 0;
        String base64hash = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        while (i < inStr.length()) {
            ascii = inStr.charAt(i);
            mod = i % 3;
            switch (mod) {
                case 0 -> result.append(base64hash.charAt(ascii >> 2));
                case 1 -> result.append(base64hash.charAt((prev & 3) << 4 | (ascii >> 4)));
                case 2 -> {
                    result.append(base64hash.charAt((prev & 0x0f) << 2 | (ascii >> 6)));
                    result.append(base64hash.charAt(ascii & 0x3f));
                }
            }
            prev = ascii;
            i++;
        }
        if (mod == 0) {
            result.append(base64hash.charAt((prev & 3) << 4));
            result.append("==");
        } else if (mod == 1) {
            result.append(base64hash.charAt((prev & 0x0f) << 2));
            result.append("=");
        }
        return result.toString();
    }
}
