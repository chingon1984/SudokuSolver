package com.chingon;



/*Wikipedia:
A brute force algorithm visits the empty cells in some order, filling in digits sequentially, or backtracking when
the number is found to be not valid. Briefly, a program would solve a puzzle by placing the digit "1" in
the first cell and checking if it is allowed to be there. If there are no violations (checking row, column, and
box constraints) then the algorithm advances to the next cell, and places a "1" in that cell. When checking for violations,
if it is discovered that the "1" is not allowed, the value is advanced to "2". If a cell is discovered where none of
the 9 digits is allowed, then the algorithm leaves that cell blank and moves back to the previous cell. The value in
that cell is then incremented by one. This is repeated until the allowed value in the last (81st) cell is discovered.*/

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


        System.out.println(sudokuArray.checkRowViolation(0) ? "Violation" : "Everything ok");

    }

    private void getNextEmpty() {
        for(int i=0; i<SIZE; i++) {
            for(int j=0; j<SIZE; j++) {
                if(sudokuArray.array[i][j] == 0) {
                    System.out.println("Row: " + i + " Column: " + j);
                    return ;
                }
            }
        }
    }


}
