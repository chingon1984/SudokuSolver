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


    }

    private void recursiveSolve() {
        /*1) if(returning value = true) -> get next empty cell | if(returning value = false) -> jump back to last cell?
         * 2) increment cell starting with 1 (1..9)
         * 3) if cell <= 9
         * 4)    check for violations
         * 5)     if NO violation:  ->    go to 1)
         * 6)     if violation:  ->   go to 2)
         * 7) if cell > 9
         * 8)    mark cell as empty  ( 0 )
         * 9)    go to last cell   -> go to 2)
         *   */
        Cell nextEmptyCell;
        try{
            nextEmptyCell = sudokuArray.getNextEmpty();
        } catch (NullPointerException e) {
            return;
        }

        int cellValue = ++sudokuArray.array[nextEmptyCell.row][nextEmptyCell.column];
        int row = nextEmptyCell.row;
        int column = nextEmptyCell.column;

        if(cellValue <= 9) {
            if(!sudokuArray.checkIfViolationExist(row,column)) {
                recursiveSolve();
            }else {

            }

        }else {

        }


    }


//    private void testViolations() {
//        int count = 0;
//        for (int i = 0; i <= SIZE; i++) {
//            System.out.println((sudokuArray.checkRowViolation(i) ? "Violation" : "Everything ok") + " in Row");
//            System.out.println((sudokuArray.checkColumnViolation(i) ? "Violation" : "Everything ok") + " in Column");
//            for (int j = 0; j < SIZE; j++) {
//                System.out.println((sudokuArray.checkBlockViolation(i, j) ? "Violation!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" : "Everything ok") + " in block");
//                count++;
//
//                if (count % 3 == 0)
//                    System.out.println("****************");
//            }
//            if (count % 27 == 0) {
//                System.out.println("******************************************");
//            }
//        }
//    }


}
