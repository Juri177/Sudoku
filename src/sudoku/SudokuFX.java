package sudoku;

import java.util.Scanner;

public class SudokuFX {

    private int[][] grid;


    public SudokuFX() {
        grid = new int[9][9];
    }

    public SudokuFX(int number){

    }


    public void nummerÄndern() {

        int row = koodrdinateAbfragen("row");
        int column = koodrdinateAbfragen("column");
        int neueZahl = readNumber("Neue Zahl:");

        if (checkValidity(row, column, neueZahl) == false) {
            System.out.println("Fehler, do passt die Zahl net hi");
            nummerÄndern();
        } else {
            grid[column][row] = neueZahl;
            displayGrid();
            System.out.println(neueZahl + " an oben=" + row + ", rechts=" + column + " eingefügt");
        }
    }


    public void nummerManuellÄndern(int column, int row, int neueZahl) {
        grid[column][row] = neueZahl;
    }


    public void displayGrid() {

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                System.out.print(grid[column][row] + " ");
                if (column % 3 == 2) {
                    System.out.print("|");
                }
            }
            System.out.println("");
            if (row % 3 == 2) {
                System.out.println("- - - - - - - - - - -");
            }
        }
    }


    //Fordert Nutzer mit eingegeben String auf eine Zahl einzugeben
    public int readNumber(String eingabeaufforderung) {
        Scanner eingabe = new Scanner(System.in);
        System.out.println(eingabeaufforderung);
        return eingabe.nextInt();

    }


    public int koodrdinateAbfragen(String Achse) {

        int zahl01 = readNumber(Achse + "-Coordinate:");
        return zahl01;
    }


    //Validity checks; gibt false zurück falls die Zahl NICHT passt

    public boolean checkValidity(int column, int row, int neueZahl) {
        if (rowValidity(row, neueZahl) == false) {
            return false;
        }
        if (columnValidity(column, neueZahl) == false) {
            return false;
        }
        if (squareValidity(column, row, neueZahl) == false) {
            return false;
        }
        return true;
    }


    public boolean rowValidity(int row, int neueZahl) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][row] == neueZahl) {
                return false;
            }
        }
        return true;
    }

    public boolean columnValidity(int column, int neueZahl) {
        for (int i = 0; i < 9; i++) {
            if (grid[column][i] == neueZahl) {
                return false;
            }
        }
        return true;
    }

    public boolean squareValidity(int column, int row, int neueZahl) {
        int x = row / 3;
        x = x * 3;
        int y = column / 3;
        y = y * 3;

        //Schleife, die Zeilen durchgeht
        for (int i = 0; i < 3; i++) {
            //Schleife, die Spalten durchgeht
            for (int j = 0; j < 3; j++) {
                if (grid[y + i][x + j] == neueZahl) {
                    return false;
                }
            }
        }
        return true;
    }


    public void makeMeAGrid() {
        nummerManuellÄndern(0, 0, 8);
        nummerManuellÄndern(1, 0, 7);
        nummerManuellÄndern(4, 0, 2);

        nummerManuellÄndern(1, 1, 6);
        nummerManuellÄndern(3, 1, 4);
        nummerManuellÄndern(4, 1, 8);

        nummerManuellÄndern(1, 2, 1);
        nummerManuellÄndern(4, 2, 5);
        nummerManuellÄndern(5, 2, 9);
        nummerManuellÄndern(7, 2, 2);
        nummerManuellÄndern(8, 2, 7);

        nummerManuellÄndern(2, 3, 2);
        nummerManuellÄndern(5, 3, 1);
        nummerManuellÄndern(6, 3, 7);
        nummerManuellÄndern(8, 3, 4);

        nummerManuellÄndern(2, 4, 8);
        nummerManuellÄndern(3, 4, 2);
        nummerManuellÄndern(5, 4, 6);
        nummerManuellÄndern(6, 4, 3);

        nummerManuellÄndern(2, 5, 4);
        nummerManuellÄndern(3, 5, 7);
        nummerManuellÄndern(6, 5, 2);
        nummerManuellÄndern(8, 5, 9);

        nummerManuellÄndern(0, 6, 3);
        nummerManuellÄndern(1, 6, 8);

        nummerManuellÄndern(3, 7, 8);
        nummerManuellÄndern(5, 7, 2);
        nummerManuellÄndern(6, 7, 9);
        nummerManuellÄndern(7, 7, 1);
        nummerManuellÄndern(8, 7, 3);

        nummerManuellÄndern(1, 8, 2);
        nummerManuellÄndern(2, 8, 7);
        nummerManuellÄndern(4, 8, 1);
        nummerManuellÄndern(5, 8, 5);
        nummerManuellÄndern(6, 8, 6);

        displayGrid();
    }

    public void makeMeAnotherGrid() {
        nummerManuellÄndern(1, 0, 5);
        nummerManuellÄndern(2, 0, 3);
        nummerManuellÄndern(3, 0, 2);
        nummerManuellÄndern(5, 0, 7);
        nummerManuellÄndern(8, 0, 8);

        nummerManuellÄndern(0, 1, 6);
        nummerManuellÄndern(2, 1, 1);
        nummerManuellÄndern(3, 1, 5);
        nummerManuellÄndern(8, 1, 2);

        nummerManuellÄndern(0, 2, 2);
        nummerManuellÄndern(3, 2, 9);
        nummerManuellÄndern(4, 2, 1);
        nummerManuellÄndern(5, 2, 3);
        nummerManuellÄndern(7, 2, 5);

        nummerManuellÄndern(0, 3, 7);
        nummerManuellÄndern(1, 3, 1);
        nummerManuellÄndern(2, 3, 4);
        nummerManuellÄndern(3, 3, 6);
        nummerManuellÄndern(4, 3, 9);
        nummerManuellÄndern(5, 3, 2);

        nummerManuellÄndern(1, 4, 2);
        nummerManuellÄndern(7, 4, 6);

        nummerManuellÄndern(3, 5, 4);
        nummerManuellÄndern(4, 5, 5);
        nummerManuellÄndern(5, 5, 1);
        nummerManuellÄndern(6, 5, 2);
        nummerManuellÄndern(7, 5, 9);
        nummerManuellÄndern(8, 5, 7);

        nummerManuellÄndern(1, 6, 6);
        nummerManuellÄndern(3, 6, 3);
        nummerManuellÄndern(4, 6, 2);
        nummerManuellÄndern(5, 6, 5);
        nummerManuellÄndern(8, 6, 9);

        nummerManuellÄndern(0, 7, 1);
        nummerManuellÄndern(5, 7, 6);
        nummerManuellÄndern(6, 7, 3);
        nummerManuellÄndern(8, 7, 4);

        nummerManuellÄndern(0, 8, 8);
        nummerManuellÄndern(3, 8, 1);
        nummerManuellÄndern(5, 8, 9);
        nummerManuellÄndern(6, 8, 6);
        nummerManuellÄndern(7, 8, 7);

        displayGrid();
    }

    public boolean isSolved() {
        for (int column = 0; column < grid.length; column++) {
            for (int row = 0; row < grid[column].length; row++) {
                if (!checkValidity(column, row, grid[column][row]) || grid[column][row] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean solve() {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[column][row] == 0) {
                    //System.out.println("Gefundenes leeres Kästchen: Spalte " + column + " Reihe " + row);
                    //Alle Zahlen von 1-9 ausprobieren
                    for (int i = 1; i <= 9; i++) {
                        //System.out.println(i);
                        //Wenns passt, einsetzten
                        if (checkValidity(column, row, i)) {
                            grid[column][row] = i;
                            //System.out.println("Eingesetzt: " + i);
                            if (solve()) {
                                return true;
                            } else {
                                grid[column][row] = 0;
                                //System.out.println("Reihe " + row + " Spalte " + column + " auf 0 gesetzt");
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}













