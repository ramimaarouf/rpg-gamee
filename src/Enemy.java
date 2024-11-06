import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemy extends Characters {
    private int x, y, w, h, speed, health, damage, stam, dx, dy;
    private weapons weapons;
    private ImageIcon pic;

    public Enemy() {
        super();
    }

    public Enemy(int x, int y, int speed, int health, int damage, int stam, ImageIcon pic, weapons weap) {
        super(x, y, 10, 10, speed, health, damage, stam, pic, weap);
        this.x = x;
        this.y = y;
        this.w = pic.getIconWidth(); // Set width based on image width
        this.h = pic.getIconHeight(); // Set height based on image height
        this.speed = speed;
        this.health = health;
        this.damage = damage;
        this.stam = stam;
        this.dx = 0;
        this.dy = 0;
        this.weapons = weap;
        this.pic = pic;
    }

    // Method to draw the enemy
    public void draw(Graphics g) {
        g.drawImage(pic.getImage(), x, y, null);
    }

    // Method to get the bounding box of the enemy
    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }

    // Method to handle taking damage
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    // Method to check if the enemy is defeated
    public boolean isDefeated() {
        return this.health <= 0;
    }

    // Getters and setters for x, y, width, height, etc.
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return w;
    }

    public void setWidth(int w) {
        this.w = w;
    }

    public int getHeight() {
        return h;
    }

    public void setHeight(int h) {
        this.h = h;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getStam() {
        return stam;
    }

    public void setStam(int stam) {
        this.stam = stam;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public ImageIcon getPic() {
        return pic;
    }

    public void setPic(ImageIcon pic) {
        this.pic = pic;
    }

    public weapons getWeapon() {
        return weapons;
    }

    public void setWeapon(weapons weapons) {
        this.weapons = weapons;
    }
}