import javax.swing.ImageIcon;

public class LavaAliens extends Enemy{
    public LavaAliens(){
        super();
    }
    public String toString(){
        return "LavaAliens";
    }
    public LavaAliens(int x,int y){
        super(x, y, 50, 125, 2, 172, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\LavaBoss.png"), new staff(100, 2, 200));
    }
    
    
}

