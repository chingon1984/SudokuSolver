package com.chingon;

/*Wikipedia:
A brute force algorithm visits the empty cells in some order, filling in digits sequentially, or backtracking when
the number is found to be not valid. Briefly, a program would solve a puzzle by placing the digit "1" in
the first cell and checking if it is allowed to be there. If there are no violations (checking row, column, and
box constraints) then the algorithm advances to the next cell, and places a "1" in that cell. When checking for violations,
if it is discovered that the "1" is not allowed, the value is advanced to "2". If a cell is discovered where none of
the 9 digits is allowed, then the algorithm leaves that cell blank and moves back to the previous cell. The value in
that cell is then incremented by one. This is repeated until the allowed value in the last (81st) cell is discovered.*/


/* Sudoku Generator
*https://www.sudoku-knacker.de
*/
public class Main {

    public static void main(String[] args) {

//        int test1[][] = new int[][]
//                {{0, 0, 2, 8, 0, 0, 7, 0, 5},
//                        {0, 0, 9, 0, 0, 0, 0, 3, 2},
//                        {7, 0, 0, 0, 6, 0, 9, 8, 0},
//                        {0, 9, 3, 0, 0, 1, 0, 0, 6},
//                        {1, 6, 0, 0, 0, 0, 8, 0, 0},
//                        {2, 0, 5, 6, 0, 0, 1, 9, 0},
//                        {0, 2, 0, 0, 3, 7, 6, 0, 0},
//                        {0, 0, 8, 0, 5, 6, 0, 2, 0},
//                        {0, 3, 6, 0, 0, 0, 5, 1, 0}};
//
//        int test2[][] = new int[][]
//                {{0, 0, 0, 0, 4, 0, 9, 8, 0},
//                        {1, 0, 0, 0, 5, 2, 0, 7, 0},
//                        {7, 3, 9, 0, 0, 6, 0, 2, 0},
//                        {0, 0, 8, 0, 6, 3, 0, 0, 0},
//                        {6, 1, 2, 0, 7, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 9, 0, 5, 0, 8},
//                        {0, 0, 0, 7, 0, 9, 0, 5, 6},
//                        {0, 2, 5, 0, 1, 0, 0, 0, 0},
//                        {0, 0, 0, 8, 0, 0, 1, 3, 4}};


        SudokuSolver sudokuSolver = new SudokuSolver();
        int[][] sudokuArray = parseArgs(args[0]);
        sudokuSolver.solve(sudokuArray);
    }

    private static int[][] parseArgs(String args) {
        int[][] result = new int[9][9];
        int counter = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String element = String.valueOf(args.charAt(counter++));
                try {
                    result[i][j] = Integer.parseInt(element);
                } catch (NumberFormatException e) {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }
}
