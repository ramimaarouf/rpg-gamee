import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class bob extends Characters {
    private weapons weapon;
    
    public bob(int x, int y, gun weapon) {
        this.weapon=new gun(10,20,30);
        

        super();
    }

    public bob(int x, int y) {
        super(x, y, 300, 300, 40, 20, 15, 1000, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\cory.png"));
    }
    public String toString(){
        return "bob"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
    public void drawWeapon(Graphics2D g, int x, int y){
        if (weapon instanceof gun){
            g.drawImage(weapon.getImage(), x, y, null);}
        }
    }
