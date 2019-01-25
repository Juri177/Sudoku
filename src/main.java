import sudoku.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        SudokuFX sudokuFX = new SudokuFX();


        int zahl01 = 4;

        sudokuFX.planquadratFinden(zahl01);

        System.out.println(zahl01);
    }


}