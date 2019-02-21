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
        recursiveSolve(sudokuArray.getNextEmptyCell());
        printResult();
    }

    private Cell recursiveSolve(Cell cell) {
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

//        *********
        printResult();
        System.out.println("*********************************");
//        ************

        int row = cell.row;
        int column = cell.column;
        int incrementedCellValue = ++sudokuArray.array[cell.row][cell.column];


        Cell nextCell;
        if (incrementedCellValue <= 9) {
            if (sudokuArray.checkIfViolationExist(row, column)) {
                return recursiveSolve(cell);
            } else {
                Cell nextFreeCell = sudokuArray.getNextEmptyCell();
                if(nextFreeCell == null)
                    return null;

                nextCell = recursiveSolve(nextFreeCell);
            }
        } else {
            // case when all values result in a Violation. -> set value of current cell to 0 and proceed with former cell
            sudokuArray.array[cell.row][cell.column] = 0;
            return cell;
        }

//      this is the case when all values in nextCell result in a Violation. ->
        if(nextCell != null && nextCell != cell) {
            nextCell = recursiveSolve(cell);
        }

        if(nextCell == null)
            return null;


        return cell;
    }

    private void printResult() {
        System.out.println("-------------------");
        for(int i=0; i<SIZE; i++) {
            System.out.print("|");
            for(int j=0; j<SIZE; j++) {
                int value = sudokuArray.array[i][j];
                System.out.print((value != 0 ? value : " ") + (j!=0 && (j+1)%3==0  ? "|" : " "));
            }
            System.out.println();
            if(i!=0 && (i+1) % 3 == 0)
                System.out.println("-------------------");
        }
    }


}
