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
        printResult();
        System.out.println("\n******** Calculating ********\n");
        long startTime = System.currentTimeMillis();
        recursiveSolve();
        long endTime = System.currentTimeMillis();
        printResult();

        System.out.println("\nElapsed time : " + (endTime - startTime) + " ms");
    }

    private boolean recursiveSolve() {

        Cell cell = sudokuArray.getNextEmptyCell();
        if(cell == null)
            return true;

        int row = cell.row;
        int column = cell.column;


        for (int i = 1; i <= 9; i++) {
            sudokuArray.array[row][column] = i;

            if (!sudokuArray.checkIfViolationExist(row, column) && recursiveSolve()) {
                return true;
            }
            sudokuArray.array[row][column] = EMPTY;
        }
        return false;
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
