import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class bob extends Characters {
    private weapons weapon;
    
    public bob(int x, int y, gun weapon) {
        this.weapon=new gun(10,20,30);
        

        super();
    }

    public bob(int x, int y) {
        super(x, y, 300, 300, 200, 100, 150, 100, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\bob.png"));
    }
    public String toString(){
        return "bob"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
    public void drawWeapon(Graphics2D g, int x, int y){
        if (weapon instanceof gun){
            g.drawImage(weapon.getImage(), x, y, null);}
        }
    }
