import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class weapons {
    private int damage;
    private int durability;
    private int dps;
    private Image image;

    public weapons(int damage, int durability, int dps, String imagePath) {
        this.damage = damage;
        this.durability = durability;
        this.dps = dps;
        this.image = new ImageIcon(imagePath).getImage();
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
    
    public Image getImage() {
        return image;
    }
    
    public void drawWeapon(Graphics g, int x, int y) {
        if (image != null) {
            g.drawImage(image, x, y, null);
        }
        g.drawString("Damage: " + damage, x, y + 20);
        g.drawString("Durability: " + durability, x, y + 40);
        g.drawString("DPS: " + dps, x, y + 60);
    }

    String getDam() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}