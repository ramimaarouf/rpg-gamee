import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class cory extends Characters {
    private weapons weapon;
    
    public cory(int x, int y, weapons weap ) {
        this.weapon=new twinblade(10,20,30, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\twinblade.png"));
        

        super();
    }

    public cory(int x, int y) {
        super(x, y, 300, 300, 55, 180, 70, 20, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\coryy.png"));
    }
    public String toString(){
        return "cory"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp()+ ""+super.getWeapon();
    }
    public void drawWeapon(Graphics2D g, int x, int y){
        if (weapon instanceof twinblade){
            g.drawImage(weapon.getImage(), x, y, null);}
        }
        public void specialAbility() {
            increaseStamina(50);
            System.out.println("stamina has increased by 50. Current damage: " + getDam());
        }
    }
    
