package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalysisTest {
    @Test
    void getShortestWay1() {
        //given
        List<String> lines = List.of(
                "London to Dublin = 464",
                "London to Belfast = 518",
                "Dublin to Belfast = 141"
        );

        List<List<String>> parts = Analysis.splitLine(lines);
        List<String> locations = Analysis.getAllLocations(parts);

        String[] elements = Main.convertListToArray(locations);

        List<List<String>> permute = Analysis.permute(elements);

        int expected = 605;

        //when
        int actual = Analysis.getShortestWay(permute, parts);

        //then
        assertEquals(expected, actual);
    }
}