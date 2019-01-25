import sudoku.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        SudokuFX sudokuFX = new SudokuFX();

        sudokuFX.nummerManuellÄndern(0, 0, 3);
        sudokuFX.nummerManuellÄndern(0, 1, 2);

        sudokuFX.displayGrid();

        System.out.println(sudokuFX.columnValidity(0, 3));
    }


}