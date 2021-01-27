package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WiresTest {

    @Test
    void getWiresSignalsFrom1() {
        //given
        List<String> lines = Reader.readFile("../../TestInput.txt");

        Wires wires = new Wires();

        //when
        int signalD = wires.getWiresSignalsFrom(lines, "d");
        int signalE = wires.getWiresSignalsFrom(lines, "e");
        int signalF = wires.getWiresSignalsFrom(lines, "f");
        int signalG = wires.getWiresSignalsFrom(lines, "g");
        int signalH = wires.getWiresSignalsFrom(lines, "h");
        int signalI = wires.getWiresSignalsFrom(lines, "i");
        int signalX = wires.getWiresSignalsFrom(lines, "x");
        int signalY = wires.getWiresSignalsFrom(lines, "y");

        Map<String, Integer> wires1 = wires.getWires();

        //then
        assertEquals(72, signalD);
        assertEquals(507, signalE);
        assertEquals(492, signalF);
        assertEquals(114, signalG);
        assertEquals(65412, signalH);
        assertEquals(65079, signalI);
        assertEquals(123, signalX);
        assertEquals(456, signalY);

    }
}