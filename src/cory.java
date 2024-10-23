import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class cory extends Characters {
    private weapons weapon;

    public cory() {
        this.weapon=new twinblade(10,20,30);

        super();
    }

    public cory(int x, int y) {
        super(x, y, 300, 300, 40, 20, 15, 1000, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\cory.png"));
    }
    public String toString(){
        return "cory"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
    public void drawWeapon(Graphics2D g, int x, int y){
        if (weapon instanceof twinblade){
            Image wepaonImage = ((twinblade)weapon)
            g.drawImage(weaponImage.getImage(), x, y, null);}
        }
    }
