package com.chingon;

public class Main {

    public static void main(String[] args) {

        int test1[][] = new int[][]
                       {{3,1,2,8,9,4,7,6,5},
                        {6,8,9,7,1,5,4,3,2},
                        {7,5,4,2,6,3,9,8,1},
                        {8,9,3,5,4,1,2,7,6},
                        {1,6,7,3,2,9,8,5,4},
                        {2,4,5,6,7,8,1,9,3},
                        {5,2,1,9,3,7,6,4,8},
                        {4,7,8,1,5,6,3,2,9},
                        {9,3,6,4,8,2,5,1,5}};




        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solve(test1);



    }
}
