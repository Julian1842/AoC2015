package com.company;

public class Main {

    public static final String INPUT = "cqjxjnds";

    public static void main(String[] args) {
        String password = INPUT;


        while(!Password.isValid(password)) {
            password = Password.generateNewPassword(password);
        }

        System.out.println(password);
    }
}
