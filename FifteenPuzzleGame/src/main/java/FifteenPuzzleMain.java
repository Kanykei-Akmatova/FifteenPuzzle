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

        gameFrame.setSize(400, 400);
        gameFrame.setIconImage(image);
        gameFrame.setLayout(null);
        gameFrame.setVisible(true);
        gameFrame.setResizable(false);
    }
}
