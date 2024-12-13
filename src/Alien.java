
import javax.swing.ImageIcon;

public class Alien extends Enemy{
    public Alien(){
        super();
    }
    public String toString(){
        return "Alien";
    }
    public Alien(int x,int y){
        super(x, y, 50, 100, 2, 172, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\alien.png"), new staff(100, 2, 200));
    }
    
}