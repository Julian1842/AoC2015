package com.company;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) throws Exception {


        List<String> lines = Reader.readFile(PATH);

        Wires wires = new Wires();

        int signalA = wires.getWiresSignalsFrom(lines);

        System.out.println(signalA);
    }
}
