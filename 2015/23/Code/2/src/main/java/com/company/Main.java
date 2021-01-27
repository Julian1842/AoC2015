package com.company;

import java.util.List;

public class Main {

    public static final String PATH = "../../Input.txt";

    public static void main(String[] args) {
        List<String> lines = Reader.readFile(PATH);

        Register regA = new Register("a");
        regA.value += 1;
        Register regB = new Register("b");
        Register instructionPointer = new Register("instructionPointer");
        List<Thunk> instructions = Analysis.getInstructions(lines, regA, regB, instructionPointer);

        int value = Analysis.solve(instructions, regA, regB, instructionPointer, regB);

        System.out.println(value);
    }
}

