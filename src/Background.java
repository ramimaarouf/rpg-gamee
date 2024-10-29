import javax.swing.ImageIcon;
import java.awt.Graphics;

public class Background {
    private ImageIcon backgroundImage;

    public Background(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath);
    }

    public void draw(Graphics g, int width, int height) {
        g.drawImage(backgroundImage.getImage(), 0, 0, width, height, null);
    }

    public ImageIcon getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath);
    }
}