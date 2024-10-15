import java.awt.Image;
import javax.swing.ImageIcon;
public class jack extends Characters {

    static Image getImage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public jack (){
super();
    }
    public jack (int x, int y){
        super(x,y,300,300,1000,400,400,600,new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\jack.png"));
    }
    public String toString(){
        return "jack"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
}