import sudoku.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        SudokuFX sudokuFX = new SudokuFX();


        //sudokuFX.makeMeAGrid();

        System.out.println(sudokuFX.isSolved());

        System.out.println(sudokuFX.solve());

        sudokuFX.displayGrid();

    }
}