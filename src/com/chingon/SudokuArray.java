package com.chingon;

public class SudokuArray {
    private final int SIZE;
    private final int EMPTY;
    public int[][] array;
    private boolean[][] validNumbers;

    public SudokuArray(int[][] array) {
        this.EMPTY = 0;
        this.SIZE = 9;
        this.array = array;

        this.validNumbers = new boolean[81][9];
        for (int i = 0; i < 81; i++)
            for (int j = 0; j < 9; j++)
                validNumbers[i][j] = true;

    }

    public int getNextPossibleNumber(int row, int column) {
        int index = 9 * row + column;
        for(int i=0; i<9 ; i++) {
            if (validNumbers[index][i])
                return i+1;
        }
        return 0;
    }

    public void deleteNumber(int row, int column, int number) {
        int index = 9 * row + column;
        validNumbers[index][number-1] = false;
    }

    public boolean checkIfViolationExist(int row, int column) {
        return (checkRowViolation(row) || checkColumnViolation(column) || checkBlockViolation(row, column));
    }

    private boolean checkRowViolation(int row) throws ArrayIndexOutOfBoundsException {
        if (row >= SIZE)
            throw new ArrayIndexOutOfBoundsException("Row was too big");
        int[] rowToCheck = array[row];
        return checkArrayViolation(rowToCheck);
    }

    private boolean checkColumnViolation(int column) throws ArrayIndexOutOfBoundsException {
        if (column >= SIZE)
            throw new ArrayIndexOutOfBoundsException("Column was too big");
        int[] columnToCheck = new int[SIZE];
        for (int i = 0; i < SIZE; i++)
            columnToCheck[i] = array[i][column];

        return checkArrayViolation(columnToCheck);
    }

    private boolean checkBlockViolation(int row, int column) throws ArrayIndexOutOfBoundsException {
        if (row >= SIZE || column >= SIZE)
            throw new ArrayIndexOutOfBoundsException("Row or Column was too big");
        int[] blockToCheck = getBlockArray(row, column);
        return checkArrayViolation(blockToCheck);
    }


    private int[] getBlockArray(int row, int column) {
        int block[] = new int[SIZE];
//        row and column belong to which of the 9 blocks. e.g.  row=4,column=7 -> block(1,2)  the 6th.
        int block_r = 3 * (row / 3);
        int block_c = 3 * (column / 3);

        int count = 0;
        for (int i = block_r; i < block_r + 3; i++) {
            for (int j = block_c; j < block_c + 3; j++) {
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

                    if (count > 1)
                        return true;
                }
            }
            count = 0;
        }
        return false;
    }


    public Cell getNextEmptyCell() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (array[i][j] == EMPTY) {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }

    public void printCheckArray(int[] array) {
        for (int elt : array) {
            System.out.print(elt + " ");
        }
        System.out.println();
    }
}
