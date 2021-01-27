package com.company;

import java.io.IOException;
import java.util.List;

public class Main {
    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) throws IOException {
        List<String> values = Reader.readFile(PATH);

        int amountOfHouses = Position.calculatePresents(values);

        System.out.println(String.format("Amount of houses: %s", amountOfHouses));
    }
}
