package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalysisTest {
    @Test
    void getPossibleMoleculesFrom1() {
        //given
        List<String> lines = Reader.readFile("../../Part1TestInput1.txt");
        Main.assignMoleculeToFind(lines);
        lines.remove(lines.size() - 1);

        Map<String, ArrayList<String>> replacements = Analysis.mapPossibleReplacements(lines);

        int expected = 4;

        //when
        ArrayList<String> possibleMolecules = Analysis.getPossibleMoleculesFrom(replacements);
        int actual = possibleMolecules.size();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void getPossibleMoleculesFrom2() {
        //given
        List<String> lines = Reader.readFile("../../Part1TestInput2.txt");
        Main.assignMoleculeToFind(lines);
        lines.remove(lines.size() - 1);

        Map<String, ArrayList<String>> replacements = Analysis.mapPossibleReplacements(lines);

        int expected = 7;

        //when
        ArrayList<String> possibleMolecules = Analysis.getPossibleMoleculesFrom(replacements);
        int actual = possibleMolecules.size();

        //then
        assertEquals(expected, actual);
    }
}