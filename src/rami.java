import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
public class rami extends Characters {
    private weapons weapon;

    
    static Image getImage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public rami (){
        this.weapon=new staff(10,20,30);
super();
    }
    public rami (int x, int y){
        super(x,y,300,300,300,500,15,1000,new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\rami.png"));
    }
    public String toString(){
        return "rami" + super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
    public void drawWeapon(Graphics2D g, int x, int y){
        if (weapon instanceof staff){
            Image wepaonImage = ((staff)weapon)
            g.drawImage(weaponImage.getImage(), x, y, null);
        }
    }
}
