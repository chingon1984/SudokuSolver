package com.chingon;

public class SudokuArray {
    private final int SIZE;
    private final int EMPTY;
    public int[][] array;

    public SudokuArray(int[][] array) {
        this.EMPTY = 0;
        this.SIZE = 9;
        this.array = array;
    }

    public boolean checkRowViolation(int row) {
        int[] rowToCheck = array[row];
        int value;
        int count = 0;

        for (int i = 0; i < SIZE; i++) {
            if (rowToCheck[i] != EMPTY) {
                value = rowToCheck[i];
                for (int j = 0; j < SIZE; j++) {
                    if (rowToCheck[j] == value)
                        count++;
                }
            }
            if(count > 1)
                return true;

            count = 0;
        }
        return false;
    }
}
