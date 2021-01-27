package com.company;

import java.util.List;
import java.util.regex.Pattern;

public class Password {
    public static String generateNewPassword(String password) {
        char[] passwordArray = password.toCharArray();

        for (int i = passwordArray.length - 1; i >= 0; i--) {
            if (passwordArray[i] != 'z') {
                passwordArray[i]++;
                break;
            } else {
                passwordArray[i] = 'a';
            }
        }

        return String.valueOf(passwordArray);
    }

    public static boolean isValid(String originPassword) {
        return (rule1(originPassword) && rule2(originPassword) && rule3(originPassword));
    }

    private static boolean rule1(String originPassword) {
        return (!originPassword.contains("i") && !originPassword.contains("o") && !originPassword.contains("l"));
    }

    private static boolean rule2(String originPassword) {
        return Pattern.matches(".*(.)\\1.*(.)\\2.*", originPassword);
    }

    private static boolean rule3(String originPassword) {
        List<String> matches = List.of("abc", "cde", "def", "efg", "fgh", "ghi", "hij", "ijk", "jkl", "klm", "lmn", "mno", "nop", "opq", "pqr", "qrs", "rst", "stu", "tuv", "uvw", "vwx", "wxy", "xyz");

        for (String match : matches) {
            if (originPassword.contains(match)) {
                return true;
            }
        }

        return false;
    }
}
