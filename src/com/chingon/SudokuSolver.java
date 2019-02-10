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

        Cell nextEmptyCell = sudokuArray.getNextEmpty();
        System.out.println("Row: " + nextEmptyCell.row + " Column: " + nextEmptyCell.column);




    }




//    private void testViolations() {
//        int count = 0;
//        for (int i = 0; i <= SIZE; i++) {
////            System.out.println((sudokuArray.checkRowViolation(i) ? "Violation" : "Everything ok") + " in Row");
////        System.out.println((sudokuArray.checkColumnViolation(i) ? "Violation" : "Everything ok") + " in Column");
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
