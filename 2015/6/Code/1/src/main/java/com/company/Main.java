package com.company;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<String> lines = Reader.readFile(PATH);

        Lights lights = new Lights();
        lights.changeLights(lines);

        int turnedOnLights = lights.getAmountOfTurnedOnLights();

        System.out.println(turnedOnLights);
    }
}
