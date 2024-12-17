
import java.util.Random;

import javax.swing.ImageIcon;

public class Alien extends Enemy{
    private static final double DROP_CHANCE = 0.5; // 50% chance to drop an item
    public Alien(){
        super();
    }
    public String toString(){
        return "Alien";
    }
    public Alien(int x,int y){
        super(x, y, 50, 100, 2, 172, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\alien.png"), new staff(100, 2, 200));
    }
    public Item dropItem(){
Random rand= new Random();
if(rand.nextDouble()<DROP_CHANCE){
    return new Item("Alien Artifcat");
}
return null;
    }
}
