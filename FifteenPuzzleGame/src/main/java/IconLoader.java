/*
 * Name:  Kanykei Akmatova
 * Date: 'May 6, 2022'
 * Description: My implementation of Fifteen Puzzle Game for my study purpose.
 */

import javax.swing.*;
import java.awt.*;

public class IconLoader {
    public static Image getImage(String filePath) {
        String path = IconLoader.class.getResource(filePath).getFile();
        return new ImageIcon(path).getImage();
    }
}
