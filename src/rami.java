import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class rami extends Characters {
    private weapons weapon;
    
    public rami(int x, int y, sword weapon) {
        this.weapon=new sword(10,20,30);
        

        super();
    }

    public rami(int x, int y) {
        super(x, y, 300, 300, 85, 150, 120, 25, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\ramii.png"));
    }
    public String toString(){
        return "rami"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
    public void drawWeapon(Graphics2D g, int x, int y){
        if (weapon instanceof twinblade){
            g.drawImage(weapon.getImage(), x, y, null);}
        }
        public void specialAbility() {
            increaseDamage(10);
            System.out.println("Damage has increased by 10. Current damage: " + getDam());
        }
    }