import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class cory extends Characters {
    private weapons weapon;
    
    public cory(int x, int y, twinblade twinblade) {
        this.weapon=new twinblade(10,20,30);
        

        super();
    }

    public cory(int x, int y) {
        super(x, y, 300, 300, 40, 20, 15, 1000, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\cory.png"));
    }
    public String toString(){
        return "cory"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp()+ ""+super.getWeapon();
    }
    public void drawWeapon(Graphics2D g, int x, int y){
        if (weapon instanceof twinblade){
            g.drawImage(weapon.getImage(), x, y, null);}
        }
    }
