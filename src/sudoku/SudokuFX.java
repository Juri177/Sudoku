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

        int x = koodrdinateAbfragen("X");
        int y = koodrdinateAbfragen("Y");
        int neueZahl = readNumber("Bitte geben Sie die Zahl ein, die sie in X=" + x +
                " Y=" + y + " einfügen möchten");

        grid[y][x] = neueZahl;
        displayGrid();
    }

    public void nummerManuellÄndern(int xKoordinate, int yKoordinate, int neueZahl) {
        grid[yKoordinate][xKoordinate] = neueZahl;
    }


    public void displayGrid() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
    }


    //Fordert Nutzer mit eingegeben String auf eine Zahl einzugeben
    public int readNumber(String eingabeaufforderung) {

        Scanner eingabe = new Scanner(System.in);

        System.out.println(eingabeaufforderung);
        return eingabe.nextInt();

    }

    public int koodrdinateAbfragen(String Achse) {

        int zahl01 = readNumber("Bitte geben sie ihre " + Achse + "-Koordinate ein(<=9)");
        return zahl01;
    }


        /*public boolean checkValidity(int xKoordinate, int yKoordinate, int neueZahl){
            return false;
        }*/

    public boolean rowValidity(int yKoordinate, int neueZahl) {
        for (int i = 0; i < 9; i++) {
            if (grid[yKoordinate][i] == neueZahl) {
                return false;
            }
        }
        return true;
    }


    public boolean columnValidity(int xKoordinate, int neueZahl) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][xKoordinate] == neueZahl) {
                return false;
            }
        }
        return true;
    }

    public boolean squareValidity(int xKoordinate, int yKoordinate, int neueZahl) {
        //Schleife, die Zeilen durchgeht
        for (int i = 0; i < 3; i++) {
            //Schleife, die Spalten durchgeht
            for (int i = 0; i < 3; i++) {
                if (grid[][])
            }
        }
    }

    public int


}


