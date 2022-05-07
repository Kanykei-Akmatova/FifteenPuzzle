import javax.swing.*;
import java.awt.*;

public class IconLoader {
    public static Image getImage(String filePath) {
        String path = IconLoader.class.getResource(filePath).getFile();
        return new ImageIcon(path).getImage();
    }
}
