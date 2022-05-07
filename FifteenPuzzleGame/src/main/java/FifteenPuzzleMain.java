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
