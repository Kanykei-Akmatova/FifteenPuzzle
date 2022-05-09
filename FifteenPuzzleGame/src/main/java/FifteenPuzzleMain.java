/*
 * Name:  Kanykei Akmatova
 * Date: 'May 6, 2022'
 * Description: My implementation of Fifteen Puzzle Game for my study purpose.
 */

import javax.swing.*;
import java.awt.*;

public class FifteenPuzzleMain {
    static final String pathToFrameIcon = "frame.png";

    public static void main(String[] args) {
        Image image = IconLoader.getImage(pathToFrameIcon);

        JFrame gameFrame = new JFrame();

        gameFrame.setSize(425, 450);
        gameFrame.setIconImage(image);
        gameFrame.setLayout(null);
        gameFrame.setVisible(true);
        gameFrame.setResizable(false);
        gameFrame.setTitle("Fifteen Puzzle");

        FifteenPuzzleGame fifteenPuzzleGame = new FifteenPuzzleGame();
        int[][] board = fifteenPuzzleGame.newGame().getBoard();

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if(board[row][col] != 0) {
                    JButton b = new JButton(String.valueOf(board[row][col]));
                    b.setBounds(100 * row + 5, 100 * col + 5, 100, 100);
                    gameFrame.add(b);
                }
            }
        }
    }
}
