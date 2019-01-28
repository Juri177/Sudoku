import sudoku.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        SudokuFX sudokuFX = new SudokuFX();
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuFX);

        sudokuFX.displayGrid();

        System.out.println(sudokuFX.isSolved());

    }
}