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
    private int width;
    private int height;

    public weapons(int damage, int durability, int dps, String imagePath) {
        this.damage = damage;
        this.durability = durability;
        this.dps = dps;
        this.image = new ImageIcon(imagePath).getImage();
    }
    public int getWidth() {
        return image != null ? image.getWidth(null) : 50; // default width if no image
    }
    
    public int getHeight() {
        return image != null ? image.getHeight(null) : 50; // default height if no image
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
       
    }

  
    public int getDam() {
        return damage;
    }
    public void setDam(int damage) {
        this.damage = damage;
    }
    void draw(Graphics2D g2d, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    public boolean hit(Enemy sm) {
        if((sm.getY()+sm.getH())>getY()&&sm.getY()<getY()+getHeight()&&
        sm.getX()<(getX()+getWidth())&&(sm.getX()+sm.getWidth())>getX()) {
            return true;
        }
                return false;
}
}   