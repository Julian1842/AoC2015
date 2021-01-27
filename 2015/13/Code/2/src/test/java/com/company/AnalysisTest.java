package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalysisTest {
    @Test
    void getHighestHappiness1() {
        //given
        String path = "../../TestInput.txt";
        List<String> lines = Reader.readFile(path);
        List<String> names = Analysis.getAllNames(lines);
        List<List<String>> happiness = Analysis.getHappiness(lines);
        List<List<String>> permutes = Analysis.permute(names.toArray(new String[0]));

        int expected = 330;

        //when
        int actual = Analysis.getHighestHappiness(permutes, happiness);

        //then
        assertEquals(expected, actual);
    }
}