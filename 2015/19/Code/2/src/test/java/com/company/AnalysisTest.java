package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class AnalysisTest {
    @Test
    void getMoleculeToESteps1() {
        List<String> lines = Reader.readFile("../../Part2TestInput1.txt");
        Main.assignMoleculeToFind(lines);
        lines.remove(lines.size() - 1);

        Map<String, String> replacements = Analysis.mapPossibleReplacements(lines);

        int steps = Analysis.getMoleculeToESteps(replacements);

        System.out.println(steps);
    }

    @Test
    void getMoleculeToESteps2() {

    }
}