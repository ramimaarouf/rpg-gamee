import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Characters{
   
    private int x,y,w,h , speed, health , damage,stam ,dx,dy;
private ImageIcon pic;

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
public void setX (int x){
    this.x=x;
}
public int getY(){
    return this.y;
}
public void setY (int y){
    this.y=y;
}
public int setW (int w){
    return this.w;
}
public int setH(int h){
    return this.h;
}
}



