package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
    public static String hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        int index = 0;
        boolean b = true;

        while(true) {
            String text = input + index;

            md.update(text.getBytes());
            byte[] digest = md.digest();

            if (digest[0] == 0 && digest[1] == 0 && (digest[2] & 0xFF) < 0x10) {
                return String.valueOf(index);
            }

            index++;
        }
    }
}