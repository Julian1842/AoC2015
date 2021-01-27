package com.company;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<String> lines = Reader.readFile(PATH);
        List<Sue> sues = Analysis.createSues(lines);
        Sue giftSue = Analysis.createGiftSue();

        Integer correctID = Analysis.getCorrectSue(sues, giftSue);

        System.out.println(correctID);
    }
}
