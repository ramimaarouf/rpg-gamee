import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class weapons {
    private int damage;
    private int durability;
    private int dps;
    private int x;
    private int y;
    private Image image;

    public weapons(int damage, int durability, int dps, String imagePath) {
        this.damage = damage;
        this.durability = durability;
        this.dps = dps;
        this.image = new ImageIcon(imagePath).getImage();
    }

    public Image getImage() {
        return image;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getX(){
        return this.x;
    }
    public void setY(int y) {
        this.y = y;
    }
    
    public int getY() {
        return y;
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getDps() {
        return dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    public void drawWeapon(Graphics g, int x, int y) {
        if (image != null) {
            g.drawImage(image, x, y, null);
        }
        g.drawString("Damage: " + damage, x, y + 20);
        g.drawString("Durability: " + durability, x, y + 40);
        g.drawString("DPS: " + dps, x, y + 60);
    }

    // Correctly implemented getDam method
    public int getDam() {
        return damage;
    }

    void draw(Graphics2D g2d, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getWidth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWidth'");
    }
    public int getHeight() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHeight'");
    }

    // void setX(int i) method removed to avoid duplication
}
    