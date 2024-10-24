import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
public class jack extends Characters {
    private weapons weapon;

    static Image getImage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public jack (){
        this.weapon=new sword(10,20,30);
super();
    }
    public jack (int x, int y){
        super(x,y,300,300,1000,400,400,600,new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\jack.png"));
    }
    public String toString(){
        return "jack"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
    public void drawWeapon(Graphics2D g, int x, int y){
        if (weapon instanceof sword){
            g.drawImage(weapon.getImage(), x, y, null);
}
    }
}