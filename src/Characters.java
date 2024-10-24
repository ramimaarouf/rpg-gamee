import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Characters{
   
    public int x,y,w,h , speed, health , damage,stam ,dx,dy;
    protected ImageIcon pic;
private weapons weap;
private weapons weapon;
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
public void drawChar (Graphics g2d){
g2d.drawImage(pic.getImage(), x , y , w, h, null);
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

    }
  