package com.chingon;

public class Main {

    public static void main(String[] args) {

        int test1[][] = new int[][]
                {{0,0,2,8,0,0,7,0,5},
                        {0,0,9,0,0,0,0,3,2},
                        {7,0,0,0,6,0,9,8,0},
                        {0,9,3,0,0,1,0,0,6},
                        {1,6,0,0,0,0,8,0,0},
                        {2,0,5,6,0,0,1,9,0},
                        {0,2,0,0,3,7,6,0,0},
                        {0,0,8,0,5,6,0,2,0},
                        {0,3,6,0,0,0,5,1,0}};


        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solve(test1);


    }
}
