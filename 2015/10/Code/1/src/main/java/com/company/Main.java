package com.company;

public class Main {

    public static final String INPUT = "1321131112";

    public static void main(String[] args) {
        int repetions = 40;

        String returnedString = INPUT;

        for (int i = 0; i < repetions; i++) {
            returnedString = Analysis.calculate(returnedString);
        }

        System.out.println(returnedString.length());
    }
}
