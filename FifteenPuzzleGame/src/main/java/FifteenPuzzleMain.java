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
        JFrame gameFrame = new JFrame();

        gameFrame.setSize(425, 450);
        gameFrame.setLayout(null);

        gameFrame.setResizable(false);
        gameFrame.setTitle("Fifteen Puzzle");

        newGame(gameFrame);
    }

    private static void newGame(JFrame gameFrame) {
        gameFrame.setVisible(false);
        gameFrame.getContentPane().removeAll();
        FifteenPuzzleGame fifteenPuzzleGame = new FifteenPuzzleGame().newGame();
        int[][] board = fifteenPuzzleGame.getBoard();

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if(board[row][col] != 0) {
                    JButton btn = new JButton(String.valueOf(board[row][col]));
                    btn.setFont(new Font("Arial", Font.BOLD, 36));

                    btn.setBounds(100 * col + 5, 100 * row + 5, 100, 100);
                    btn.addActionListener( e-> {
                        Rectangle bounds = btn.getBounds();
                        int c = (int) ((bounds.getX() - 5) / 100);
                        int r = (int) ((bounds.getY() - 5) / 100);

                        int[] move = fifteenPuzzleGame.getMove(r,c);
                        btn.setBounds(100 * move[1] + 5, 100 * move[0] + 5, 100, 100);
                        gameFrame.revalidate();

                        if(fifteenPuzzleGame.isSolved()){
                            int toContinue = showModal(gameFrame);
                            if(toContinue == 0)
                            {
                                newGame(gameFrame);
                            }
                            else {
                                gameFrame.dispose();
                            }
                        }
                    });
                    gameFrame.add(btn);
                }
            }
        }

        gameFrame.setVisible(true);
        gameFrame.revalidate();
    }

    private static int showModal(JFrame gameFrame) {
        Object[] options = {"Yes, please.", "No, thanks."};
        int n = JOptionPane.showOptionDialog(gameFrame,
                "Do you want to continue ?",
                "Congratulation, you win !!!",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        return n;
    }
}
