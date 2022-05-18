/*
 * Name:  Kanykei Akmatova
 * Date: 'May 6, 2022'
 * Description: My implementation of Fifteen Puzzle Game for my study purpose.
 */

import java.util.Random;

public class FifteenPuzzleGame {
    private static final int NB_TILES = 16;
    private static final int NB_ROW_TILES = 4;
    private static int[][] board = new int[NB_ROW_TILES][NB_ROW_TILES];
    private static final Random RANDOM = new Random();

    public FifteenPuzzleGame(){
    }

    public FifteenPuzzleGame newGame() {
        do {
            reset(); // reset to initial state
            shuffle(); // shuffle tiles on the board
        } while(!isSolvable()); // make it until board be solvable
        return this;
    }

    public final int[][] getBoard() {
        return board;
    }

    private static void reset() {
        board = new int[NB_ROW_TILES][NB_ROW_TILES];
    }

    public static int[] getMove(int row, int col) {
        int nextRow = row;
        int nextCol = col;

        // Move down
        if (row < 3 && board[row + 1][col] == 0) {
            nextRow++;
        }
        // Move up
        if (row > 0 && board[row - 1][col] == 0) {
            nextRow--;
        }
        // Move right
        if (col < 3 && board[row][col + 1] == 0) {
            nextCol++;
        }
        // Move left
        if (col > 0 && board[row][col - 1] == 0) {
            nextCol--;
        }
        // Swap if possible
        if(row != nextRow || col != nextCol) {
            board[nextRow][nextCol] = board[row][col];
            board[row][col] = 0;
        }

        return new int[]{nextRow, nextCol};
    }

    public static boolean isSolved() {
        int expectedTile = 1;
        for (int r = 0; r < NB_ROW_TILES; r++) {
            for (int c = 0; c < NB_ROW_TILES; c++) {
                // if it is the last cell of the board then we expect 0 value
                if (r == NB_ROW_TILES - 1 && c == NB_ROW_TILES - 1) {
                    expectedTile = 0;
                }

                // checking if a tile value is in order
                if (board[r][c] != expectedTile) {
                    return false;
                }

                expectedTile++;
            }
        }

        return true;
    }

    public static int[] toOneRow(int[][] data) {
        int[] oneRow = new int[data.length * data.length];

        int index = 0;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data.length; col++) {
                oneRow[index] = data[row][col];
                index++;
            }
        }

        return oneRow;
    }

    private boolean isSolvable()
    {
        int countOfInversions = 0;

        int[] tiles = toOneRow(board);
        for (int i = 0; i < NB_TILES; i++) {
            for (int j = 0; j < i; j++) {
                if (tiles[j] > tiles[i])
                    countOfInversions++;
            }
        }

        return countOfInversions % 2 == 0;
    }

    private static void shuffle() {
        for (int index = 0; index < NB_TILES; index++) {
            int r = (int) (Math.random() * NB_ROW_TILES);
            int c = (int) (Math.random() * NB_ROW_TILES);

            while (!(board[r][c] == 0)) {
                r = (int) (Math.random() * NB_ROW_TILES);
                c = (int) (Math.random() * NB_ROW_TILES);
            }

            board[r][c] = index;
        }
    }
}
