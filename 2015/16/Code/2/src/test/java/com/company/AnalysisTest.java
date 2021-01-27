package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalysisTest {

    @Test
    void getCorrectSue1() {
        //given
        Sue giftSue = new Sue(6, 5, 4, 3, 2, 1, 9, 0, 7, 9);
        List<String> lines = Reader.readFile("../../Input.txt");
        List<Sue> sues = Analysis.createSues(lines);

        int expected = 29;

        //when
        int actual = Analysis.getCorrectSue(sues, giftSue);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void getCorrectSue2() {
        //given
        Sue giftSue = new Sue(3, 15, 25, 8, 1, 10, 6, 7, 8, 9);
        List<String> lines = Reader.readFile("../../Input.txt");
        List<Sue> sues = Analysis.createSues(lines);

        int expected = 104;

        //when
        int actual = Analysis.getCorrectSue(sues, giftSue);

        //then
        assertEquals(expected, actual);
    }
}