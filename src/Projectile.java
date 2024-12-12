import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Projectile extends Ranged {
    private int x, y;
    private int speed;
    private int direction;
    private Image image;
    private int dx;
    private int dy;
    public int width;
    private int height;

    public Projectile(int x, int y, int width, String name, String imagePath) {
        super(x, y,width,name);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
    public int getdy(){
        return this.dy;
    }
    public void setdy(int dy){
        this.dy=dy;
    }
    public void setdx(int dx){
        this.dx=dx;
    }
    public int getdx(int Dx){
        return this.dx;
    }
    public void draw(Graphics g) {
        if (image != null) {
            g.drawImage(image, x, y, null);
        }
    }
    public void speed(int speed){
        this.speed=speed;
    }
    public int getSpeed(){
        return this.speed;
    }
    public void move() {
        
        x += speed;
  
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean hit(Enemy sm) {
        if((sm.getY()+sm.getH())>getY()&&sm.getY()<getY()+getHeight()&&
        sm.getX()<(getX()+getWidth())&&(sm.getX()+sm.getWidth())>getX()) {
            return true;
        }
                return false;
}
}   
   

    
