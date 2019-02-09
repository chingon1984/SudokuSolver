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


    public boolean checkRowViolation(int row) throws ArrayIndexOutOfBoundsException{
        if(row >= SIZE)
            throw new ArrayIndexOutOfBoundsException("Row was too big");
        int[] rowToCheck = array[row];
        return checkArrayViolation(rowToCheck);
    }
    
    public boolean checkColumnViolation(int column) throws ArrayIndexOutOfBoundsException {
        if(column >= SIZE)
            throw new ArrayIndexOutOfBoundsException("Column was too big");
        int[] columnToCheck = new int[SIZE];
        for(int i=0; i<SIZE; i++)
            columnToCheck[i] = array[i][column];

        return checkArrayViolation(columnToCheck);
    }

    public boolean checkBlockViolation(int row, int column) throws ArrayIndexOutOfBoundsException {
        if(row >= SIZE || column >= SIZE)
            throw new ArrayIndexOutOfBoundsException("Row or Column was too big");
        int[] blockToCheck = getBlockArray(row,column);
        return checkArrayViolation(blockToCheck);
    }
    

    private int[] getBlockArray(int row, int column) {
        int block[] = new int[SIZE];
//        row and column belong to which of the 9 blocks. e.g.  row=4,column=7 -> block(1,2)  the 6th.
        int block_r = 3* (row / 3);
        int block_c = 3* (column / 3);

        int count = 0;
        for(int i=block_r; i<block_r + 3; i++) {
            for(int j=block_c; j<block_c + 3; j++) {
                block[count++] = array[i][j];
            }
        }
        return block;
    }

    private boolean checkArrayViolation(int[] checkArray) {
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
