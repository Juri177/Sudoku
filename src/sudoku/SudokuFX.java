package sudoku;

import java.util.Scanner;

public class SudokuFX {

    private int[][] grid;


    public SudokuFX() {

        //Grid erstellen
        /*int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 6, 9, 1, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };*/
        grid = new int[9][9];
    }


    public void nummerÄndern() {

        int row = koodrdinateAbfragen("row");
        int column = koodrdinateAbfragen("column");
        int neueZahl = readNumber("Neue Zahl:");

        if (checkValidity(row, column, neueZahl) == false) {
            System.out.println("Fehler, do passt die Zahl net hi");
            nummerÄndern();
        } else {
            grid[row][column] = neueZahl;
            displayGrid();
            System.out.println(neueZahl + " an oben=" + row + ", rechts=" + column + " eingefügt");
        }
    }


    public void nummerManuellÄndern(int row, int column, int neueZahl) {
        grid[row][column] = neueZahl;
    }


    public int[][] getGrid() {
        return grid;
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

    public boolean checkValidity(int row, int column, int neueZahl) {
        if (!rowValidity(row, neueZahl) || !columnValidity(column, neueZahl) || !squareValidity(row, column, neueZahl)) {
            return false;
        }
        return true;
    }


    public boolean rowValidity(int row, int neueZahl) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == neueZahl) {
                return false;
            }
        }
        return true;
    }

    public boolean columnValidity(int column, int neueZahl) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][column] == neueZahl) {
                return false;
            }
        }
        return true;
    }

    public boolean squareValidity(int row, int column, int neueZahl) {
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

    public boolean isSolved() {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (!checkValidity(column, row, grid[row][column]) || grid[row][column] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean solve() {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 0) {
                    for (int i = 1; i <= 9; i++) {
                        if (checkValidity(column, row, i)) {
                            grid[row][column] = i;
                        }else {
                            grid[row][column] = 0;
                        }
                    }
                }
            }
        }
        return true;
    }

}

