package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisTest {
    @Test
    void getCode() {
        //given
        int expected = 12;

        //when
        int actual = getCodeDummy();

        //then
        assertEquals(expected, actual);
    }

    public int getCodeDummy() {
        int[][] codesArray = new int[100][100];
        codesArray[1][1] = 1;

        int number = 1;

        for (int row = 2; row < codesArray.length; row++) {

            int rowIndex = row;

            for (int column = 1; column <= row && rowIndex >= 1; rowIndex--, column++) {
                number = (number + 1);
                codesArray[rowIndex][column] = number;
            }
        }

        return codesArray[4][2];
    }
}