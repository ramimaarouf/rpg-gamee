import javax.swing.ImageIcon;

public class AlienBoss extends Enemy{
    public AlienBoss(){
        super();
    }
    public String toString(){
        return "Alien";
    }
    public AlienBoss(int x,int y){
        super(x, y, 25, 500, 75, 170, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\Alienbosss.png"), new staff(100, 2, 200));
    }
    
    
}