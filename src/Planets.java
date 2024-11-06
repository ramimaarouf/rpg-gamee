import java.awt.*;
import javax.swing.*;

public class Planets {
    private String name;
    private String imagePath;
    private ImageIcon backgroundImage;

    public Planets(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
        this.backgroundImage = new ImageIcon(imagePath);
    }

    public void drawBackground(Graphics g, int width, int height) {
        g.drawImage(backgroundImage.getImage(), 0, 0, width, height, null);
    }

    // Getters and setters if needed
}