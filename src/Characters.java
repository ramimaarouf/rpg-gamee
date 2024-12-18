import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Characters{
    public boolean isInvincible() {
        return isInvincible;
    }
    public int x,y,w,h , speed, health , damage,stam ,dx,dy;
    protected ImageIcon pic;
private weapons weap;
private weapons weapon;
private Inventory inventory;
private weapons currentWeapon;
private boolean isInvincible = false;
public Characters (){
    x=0;
    y=0;
    w=0;
    h=0;
    speed=0;
    health=0;
    damage=0;
    stam=0;
    dx=0;
    dy=0;
pic=new ImageIcon();
}
public Characters (int xV, int yV, int width, int height , int sp, int hea, int st,int dam ,ImageIcon p,weapons weap){
    x=xV;
    y=yV;
    w=width;
    h=height;
    speed=sp;
    health=hea;
    damage=dam;
    stam=st;
    pic=p;
    dx=0;
    dy=0;
   this.weap=weap;
   this.inventory = new Inventory();
}
public Characters (int xV, int yV, int width, int height , int sp, int hea, int st,int dam ,ImageIcon p){
    x=xV;
    y=yV;
    w=width;
    h=height;
    speed=sp;
    health=hea;
    damage=dam;
    stam=st;
    pic=p;
    dx=0;
    dy=0;
}
public void drawChar(Graphics g2d) {
    g2d.drawImage(pic.getImage(), x, y, w, h, null);
    if (weapon != null) {
        weapon.drawWeapon(g2d, x + 50, y + 50);
    }
    if (currentWeapon != null) {
        int weaponX = x + w; 
        int weaponY = y;
        g2d.drawImage(currentWeapon.getImage(), weaponX, weaponY, 50, 50, null);
    }
    
}
public int getX(){
    return this.x;
}
public int getY(){
    return this.y;
}
public int getW (){
    return this.w;
}
public int getH(){
    return this.h;
}
public int getSp(){
    return this.speed;

}
public int getHea(){
    return this.health;
}
public int getDam(){
    return this.damage;
}
public int getStam(){
    return this.stam;

}
public int getDx(int Dx){
    return this.dx;


}
public int getDy(int Dy){
    return this.dy;

}
public ImageIcon getPic ( )
{return pic;}
//setters
public void setX (int x){
    this.x=x;
}
public void setY (int y){
    this.y=y;
}
public void setW (int w){
    this.w=w;
}
public void setH(int h){
    this.h=h;

}
public void setSP (int speed){
    this.speed=speed;
}
public void setHea(int health){
    this.health=health;
}
public void setDam(int damage){
    this.damage=damage;
}
public void setStam(int stamina){
    this.stam=stamina;
}
public void setDx(int dx){
    this.dx=dx;
}
public void setDy(int dy){
    this.dy=dy;
}
public weapons getWeapon() {
        return weapon;
}
public void setWeapon(weapons weapon) {
        this.weapon = weapon;
}
 public int getDps() {
        return weapon != null ? weapon.getDps() : 0;
    }

    public void setDps(int dps) {
        if (weapon != null) {
            weapon.setDps(dps);
        }
    }
     public int getDur() {
        return weapon != null ? weapon.getDurability() : 0;
    }

            public void setDur(int durability) {
            if (weapon != null) {
                weapon.setDurability(durability);
            }
        }

        public boolean attack(Ranged ranged) {
                    return false;
        }
        public boolean hit (Melee melee){
            return false;
        }   
        public Rectangle getBounds() {
            return new Rectangle(x, y, w, h);
        }
    Object getImage() {
        return null;
    }
    public void increaseDamage(int amount) {
        this.damage += amount;
    }
    public void increaseSpeed(int amount) {
        this.speed += amount;
    }
    public void increaseHealth(int amount) {
        this.health += amount;
    }
    public void increaseStamina(int amount) {
        this.stam += amount;
    }
    public void move(int deltaX, int deltaY) {
        if (stam > 0) {
            int speedMultiplier = getSpeedMultiplier();
            x += deltaX * speedMultiplier;
            y += deltaY * speedMultiplier;
            decreaseStamina(1);
            System.out.println("Losing stamina. Current stamina: " + stam);
            if (stam < 5) {
                System.out.println("Not enough stamina to move");
            }
        } else {
            noStamina();
        }
    }

    private int getSpeedMultiplier() {
        if (speed > 75) {
            return 3; 
        } else if (speed > 50) {
            return 2; 
        } else {
            return 1; 
        }
    }
    public  void decreaseStamina(int amount) {
        stam -= amount;
        if (stam < 0) {
            stam = 0;
        }
    }
    public void regenerateStamina() {
        stam += 5;
        if (stam > 100) {
            stam = 100;
        }
    }   
    public void noStamina(){
        if (stam==0){
            System.out.println("No stamina left");
        }
        
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public void setInvincible(boolean invincible) {
        this.isInvincible = invincible;
    }
    public boolean checkPlayerHit() {
        if (isInvincible) {
            System.out.println("Player is invincible. No damage taken.");
            return false;
        }
        return true; 
    }
}
  