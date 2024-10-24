
import javax.swing.ImageIcon;

public class Enemy extends Characters {
    private int x, y, w, h, speed, health, damage, stam, dx, dy;
    private weapons weapons;
    

    public Enemy(){
        super();
    }
    public Enemy(int x , int y, int speed, int health , int damage , int stam , ImageIcon pic, weapons weap){
        this.x = x;
        this.y = y;
        this.w = 0; 
        this.h = 0; 
        this.speed = speed;
        this.health = health;
        this.damage = damage;
        this.stam = stam;
        this.dx = 0;
        this.dy = 0;
        this.weapons = weap;
        super(x, y, 10, 10, speed, health, damage, stam, pic, weap);
        x = 0;
        y = 0;
        w = 0;
        h = 0;
        speed = 0;
        health = 0;
        damage = 0;
        stam = 0;
        dx = 0;
        dy = 0;
        pic = new ImageIcon();
        weap = null;
    }
    public Enemy(int xV, int yV, int width, int height, int sp, int hea, int st, int dam, ImageIcon p, weapons weap) {
        x = xV;
        y = yV;
        w = width;
        h = height;
        speed = sp;
        health = hea;
        damage = dam;
        stam = st;
        pic = p;
        dx = 0;
        dy = 0;
        this.weapons = weap;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.w;
    }

    public int getHeight() {
        return this.h;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getStamina() {
        return this.stam;
    }

    public int getDx() {
        return this.dx;
    }

    public int getDy() {
        return this.dy;
    }

    public ImageIcon getPic() {
        return this.getPic();
    }

    public weapons getWeapon() {
        return this.weapons;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int w) {
        this.w = w;
    }

    public void setHeight(int h) {
        this.h = h;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setStamina(int stam) {
        this.stam = stam;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void setPic(ImageIcon pic) {
        this.pic = pic;
    }

    public void setWeapon(weapons weap) {
        this.weapons = weap;
    }
}

