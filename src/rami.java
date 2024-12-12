import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class rami extends Characters {
    private weapons weapon;
    
    public rami(int x, int y, sword weapon) {
        this.weapon=new sword(10,20,30);
        

        super();
    }

    public rami(int x, int y) {
        super(x, y, 300, 300, 4000, 150, 1500, 1000, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\rami.png"));
    }
    public String toString(){
        return "rami"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
    public void drawWeapon(Graphics2D g, int x, int y){
        if (weapon instanceof twinblade){
            g.drawImage(weapon.getImage(), x, y, null);}
        }
    }
