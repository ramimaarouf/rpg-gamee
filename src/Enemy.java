import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy extends Characters {
    private int x, y, w, h, speed, health, damage, stam, dx, dy;
    private weapons weapons;
    private ImageIcon pic;
        private Random random;
    
        public Enemy() {
            super();
            this.random = new Random();

        }
    
        public Enemy(int x, int y, int speed, int health, int damage, int stam, ImageIcon pic, weapons weap) {
            super(x, y, 10, 10, speed, health, damage, stam, pic, weap);
            this.x = x;
            this.y = y;
            this.w = pic.getIconWidth(); 
            this.h = pic.getIconHeight(); 
            this.speed = speed;
            this.health = health;
            this.damage = damage;
            this.stam = stam;
            this.dx = 0;
            this.dy = 0;
            this.weapons = weap;
            this.pic = pic;
            this.random = new Random(); 
    }
    public void updatePosition() {
        if (random.nextInt(100) < 5) { 
            dx = random.nextInt(11) - 5; 
            dy = random.nextInt(11) - 5; 
        }

        // Update position
        x += dx;
        y += dy;
    }
    public void draw(Graphics g) {
        g.drawImage(pic.getImage(), x, y, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public boolean isDefeated() {
        return this.health <= 0;
    }

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