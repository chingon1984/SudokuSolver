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
        printCheckArray(rowToCheck);
        return checkViolation(rowToCheck);
    }
    
    public boolean checkColumnViolation(int column) {
        int[] columnToCheck = new int[SIZE];
        for(int i=0; i<SIZE; i++)
            columnToCheck[i] = array[i][column];

        printCheckArray(columnToCheck);
        return checkViolation(columnToCheck);
    }

    public boolean checkBlockViolation(int row, int column) {
        int[] blockToCheck = getBlockArray(row,column);
        printCheckArray(blockToCheck);
        return checkViolation(blockToCheck);
    }
    

    private int[] getBlockArray(int row, int column) {
        int box[] = new int[SIZE];
        int box_r = 3* (row / 3);
        int box_c = 3* (column / 3);

        int count = 0;
        for(int i=box_r; i<box_r + 3; i++) {
            for(int j=box_c; j<box_c + 3; j++) {
                box[count++] = array[i][j];
            }
        }
        return box;
    }

    private boolean checkViolation(int[] checkArray) {
        int value;
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (checkArray[i] != EMPTY) {
                value = checkArray[i];
                for (int j = 0; j < SIZE; j++) {
                    if (checkArray[j] == value)
                        count++;
                }
            }
            if(count > 1)
                return true;

            count = 0;
        }
        return false;
    }

    public void printCheckArray(int[] array) {
        for(int elt : array) {
            System.out.print(elt + " ");
        }
        System.out.println();
    }
}
