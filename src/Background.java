import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Background {
    private ImageIcon backgroundImage;

  
    public Background() {
        this.backgroundImage = new ImageIcon(":\\Users\\\\Demon\\Desktop\\rpg-gamee\\images\\planett.png");
    }

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