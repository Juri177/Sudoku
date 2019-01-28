package sudoku;

public class SudokuSolver {

    private SudokuFX sudokuFX;
    private int[][] grid;
    public SudokuSolver(int[][] grid){
        this.grid = grid;
    }

 /*   public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // we search an empty cell
                if (board[row][col] == EMPTY) {
                    // we try possible numbers
                    for (int number = 1; number <= SIZE; number++) {
                        if (isOk(row, col, number)) {
                            // number ok. it respects sudoku constraints
                            board[row][col] = number;

                            if (solve()) { // we start backtracking recursively
                                return true;
                            } else { // if not a solution, we empty the cell and we continue
                                board[row][col] = EMPTY;
                            }
                        }
                    }
                    return false; // we return false
                }
            }
        }
        return true; // sudoku solved
    }*/



}
