package com.company;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static final String INPUT = "ckczppom";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String hash = Hashing.hash(INPUT);
        System.out.println(hash);
    }
}
