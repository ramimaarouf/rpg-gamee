import java.awt.Image;
import javax.swing.ImageIcon;
public class bob extends Characters {

    static Image getImage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public bob (){
super();
    }
    public bob (int x, int y){
        super(x,y,300,300,15,5000,500,450,new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\bob.png"));
    }
    public String toString(){
        return "bob"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
}