import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
public class bob extends Characters {
    private weapons weapon;


    static Image getImage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public bob (){
        this.weapon=new gun(10,20,30);

super();
    }
    public bob (int x, int y){
        super(x,y,300,300,15,5000,500,450,new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\bob.png"));
    }
    public String toString(){
        return "bob"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
    public void drawWeapon(Graphics2D g, int x, int y){
        if (weapon instanceof gun){
            Image wepaonImage = ((gun)weapon)
            g.drawImage(weaponImage.getImage(), x, y, null);
        }
    }
}