package com.company;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        Analysis analysis = new Analysis();

        long code = analysis.getCode();

        System.out.println(code);
    }
}
