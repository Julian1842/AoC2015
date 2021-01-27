package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalysisTest {

    @Test
    void solve() {
        //given
        List<String> lines = Reader.readFile("../../TestInput.txt");

        Register regA = new Register("a");
        regA.value += 1;
        Register regB = new Register("b");
        Register instructionPointer = new Register("instructionPointer");
        List<Thunk> instructions = Analysis.getInstructions(lines, regA, regB, instructionPointer);

        int expected = 7;

        //when
        int actual = Analysis.solve(instructions, regA, regB, instructionPointer, regA);

        //then
        assertEquals(expected, actual);
    }
}