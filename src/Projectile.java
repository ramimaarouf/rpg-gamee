import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Projectile extends Ranged {
    private int x, y;
    private int speed;
    private int direction;
    private Image image;

    public Projectile(int x, int y, int speed, String name, String imagePath) {
        super(x, y, speed, name);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.image = new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\MISSLEE.png").getImage();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return image != null ? image.getWidth(null) : 10; 
    }

    public int getHeight() {
        return image != null ? image.getHeight(null) : 10; 
    }

    public Image getImage() {
        return image;
    }

    public void draw(Graphics g) {
        if (image != null) {
            g.drawImage(image, x, y, null);
        }
    }

    public void move() {
        
        x += speed;
    }
}