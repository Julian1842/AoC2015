package com.company;

public class Analysis {
    private long[][] codesArray = new long[10000][10000];
    private static final long START_CODE = 20151125L;
    private static final long MULTIPLIER = 252533L;
    private static final long DIVIDER = 33554393L;
    private static final int ROW_TO_FIND = 2981;
    private static final int COLUMN_TO_FIND = 3075;

    public long getCode() {
        codesArray[1][1] = START_CODE;

        long number = START_CODE;

         for (int row = 2; row < codesArray.length; row++) {

             int rowIndex = row;

             for (int column = 1; column <= row && rowIndex >= 1; rowIndex--, column++) {
                number = (number * MULTIPLIER) % DIVIDER;
                codesArray[rowIndex][column] = number;
             }
         }

        return codesArray[ROW_TO_FIND][COLUMN_TO_FIND];
    }
}
