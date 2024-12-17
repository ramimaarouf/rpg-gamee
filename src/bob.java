import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class bob extends Characters {
    private weapons weapon;
    
    public bob(int x, int y, gun weapon) {
        this.weapon=new gun(10,20,30);
        

        super();
    }

    public bob(int x, int y) {
        super(x, y, 300, 300, 100, 75, 150, 30, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\bobb.png"));
    }
    public String toString(){
        return "bob"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
    public void drawWeapon(Graphics2D g, int x, int y){
        if (weapon instanceof gun){
            g.drawImage(weapon.getImage(), x, y, null);}
        }
        public void specialAbility() {
            increaseHealth(30);
            System.out.println("Health has increased by 30. Current damage " );
        }
    }
