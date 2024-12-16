import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class jack extends Characters {
    private weapons weapon;
    
    public jack(int x, int y, staff weapon) {
        this.weapon=new staff(10,20,30);
        

        super();
    }

    public jack(int x, int y) {
        super(x, y, 300, 300, 20, 120, 150, 20, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\jackk.png"));
    }
    public String toString(){
        return "jack"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
    public void drawWeapon(Graphics2D g, int x, int y){
        if (weapon instanceof staff){
            g.drawImage(weapon.getImage(), x, y, null);}
        }
        public void specialAbility() {
            increaseSpeed(50);
            System.out.println("Speed has increased by 50. Current damage: " + getDam());
        }
    }
    
