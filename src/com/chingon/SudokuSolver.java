package com.chingon;


public class SudokuSolver {
    private final int SIZE;
    private final int EMPTY;
    private SudokuArray sudokuArray;


    public SudokuSolver() {
        this.EMPTY = 0;
        this.SIZE = 9;
    }

    public void solve(int[][] array) {
        this.sudokuArray = new SudokuArray(array);
        recursiveSolve();
        printResult();
    }

    private boolean recursiveSolve() {
        Cell cell = sudokuArray.getNextEmptyCell();

        if (cell != null) {
            int row = cell.row;
            int column = cell.column;
            int nextNumber = sudokuArray.getNextPossibleNumber(row, column);

            if (nextNumber != 0) {
                sudokuArray.array[row][column] = nextNumber;
//            *****
                printResult();
                System.out.println("*********************************");
//            ********

                if (!sudokuArray.checkIfViolationExist(row, column)) {
                    sudokuArray.deleteNumber(row, column, nextNumber);
                    sudokuArray.array[row][column] = EMPTY;
                }
                recursiveSolve();
            }
            return false;
        }

        return true;
    }

    private void printResult() {
        System.out.println("-------------------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE; j++) {
                int value = sudokuArray.array[i][j];
                System.out.print((value != 0 ? value : " ") + (j != 0 && (j + 1) % 3 == 0 ? "|" : " "));
            }
            System.out.println();
            if (i != 0 && (i + 1) % 3 == 0)
                System.out.println("-------------------");
        }
    }
}
