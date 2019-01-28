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

        int oben = koodrdinateAbfragen("oben");
        int rechts = koodrdinateAbfragen("rechts");
        int neueZahl = readNumber("Neue Zahl:");

        if (checkValidity(oben, rechts, neueZahl) == false){
            System.out.println("Fehler, do passt die Zahl net hi");
            nummerÄndern();
        }else {
            grid[rechts][oben] = neueZahl;
            displayGrid();
            System.out.println(neueZahl + " an oben=" + oben + ", rechts=" + rechts + " eingefügt");
        }
    }


    public void nummerManuellÄndern(int oben, int rechts, int neueZahl) {
        grid[oben][rechts] = neueZahl;
    }


    public void displayGrid() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[j][i] + " ");
                if (j%3 == 2){
                    System.out.print("|");
                }
            }
            System.out.println("");
            if (i%3 == 2){
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

        int zahl01 = readNumber(Achse + "-Koordinate:");
        return zahl01;
    }



    //Validity checks; gibt false zurück falls die Zahl NICHT passt

    public boolean checkValidity(int oben, int rechts, int neueZahl){
            if (rowValidity(oben, neueZahl)  == false){
                return false;
            }

            if (columnValidity(rechts, neueZahl) == false){
                return false;
            }

            if (squareValidity(oben, rechts, neueZahl) == false){
                return false;
            }

            return true;
        }


    public boolean rowValidity(int oben, int neueZahl) {
        for (int i = 0; i < 9; i++) {
            if (grid[oben][i] == neueZahl) {
                return false;
            }
        }
        return true;
    }

    public boolean columnValidity(int rechts, int neueZahl) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][rechts] == neueZahl) {
                return false;
            }
        }
        return true;
    }

    public boolean squareValidity(int oben, int rechts, int neueZahl) {
        int x = oben/3;
        x = x * 3;
        int y = rechts/3;
        y = y * 3;

        //Schleife, die Zeilen durchgeht
        for (int i = 0; i < 3; i++) {
            //Schleife, die Spalten durchgeht
            for (int j = 0; j < 3; j++) {
                if (grid [y+i] [x+j] == neueZahl){
                    return false;
                }
            }
        }
        return true;
    }


    public void makeMeAGrid(){
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

}

