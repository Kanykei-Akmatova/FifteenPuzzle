/*
 * Name:  Kanykei Akmatova
 * Date: 'May 6, 2022'
 * Description: My implementation of Fifteen Puzzle Game for my study purpose.
 */

import java.util.Random;

public class FifteenPuzzleGame {
    private static final int nbTiles = 16;
    private static final int nbInlineTiles = 4;
    private static int[][] board = new int[nbInlineTiles][nbInlineTiles];
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
        for (int r = 0; r < nbInlineTiles; r++) {
            for (int c = 0; c < nbInlineTiles; c++) {
                board[r][c] = 0;
            }
        }
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

    private static boolean isOver() {
        int expectedTile = 1;
        for (int r = 0; r < nbInlineTiles; r++) {
            for (int c = 0; c < nbInlineTiles; c++) {
                // if it is the last cell of the board then we expect 0 value
                if (r == nbInlineTiles - 1 && c == nbInlineTiles - 1) {
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

    // There is only half permutations of the Fifteen Puzzle Game are solvable and w check it here.
    // Whenever a tile is preceded by a tile with higher value it counts
    // as an inversion. In our case, with the blank tile in the solved position,
    // the number of inversions must be even for the puzzle to be solvable
    private static boolean isSolvable() {
        int countInversions = 0;
        int[] tiles = new int[nbTiles];

        int index = 0;
        for (int r = 0; r < nbInlineTiles; r++) {
            for (int c = 0; c < nbInlineTiles; c++) {
                tiles[index] = board[r][c];
                index++;
            }
        }

        for (int i = 0; i < nbTiles; i++) {
            for (int j = 0; j < i; j++) {
                if (tiles[j] > tiles[i])
                    countInversions++;
            }
        }

        return countInversions % 2 == 0;
    }

    private static void shuffle() {
        for (int index = 0; index < nbTiles; index++) {
            int r = (int) (Math.random() * nbInlineTiles);
            int c = (int) (Math.random() * nbInlineTiles);

            while (!(board[r][c] == 0)) {
                r = (int) (Math.random() * nbInlineTiles);
                c = (int) (Math.random() * nbInlineTiles);
            }

            board[r][c] = index;
        }
    }
}
