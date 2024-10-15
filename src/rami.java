import java.awt.Image;
import javax.swing.ImageIcon;
public class rami extends Characters {

    static Image getImage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public rami (){
super();
    }
    public rami (int x, int y){
        super(x,y,300,300,300,500,15,1000,new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\rami.png"));
    }
    public String toString(){
        return "rami" + super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
}
