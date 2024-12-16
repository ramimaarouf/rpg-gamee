import javax.swing.ImageIcon;

public class LavaBoss extends Enemy{
    public LavaBoss(){
        super();
    }
    public String toString(){
        return "LavaBoss";
    }
    public LavaBoss(int x,int y){
        super(x, y, 25, 800, 90, 170, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\LavaAlien.png"), new staff(100, 2, 200));
    }
    public void specialAbility() {
        setDamage(getDamage() + 30);
        System.out.println("LavaBoss used special ability! Damage increased by 30. Current damage: " + getDamage());
    }
}