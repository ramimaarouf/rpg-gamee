
import javax.swing.ImageIcon;

public class staff extends weapons{

    private ImageIcon image;
    public staff (){
        super(15, 80, 7, "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images");
    }
    public staff (int d, int du, int dp){
        super(100,2,200);
        this.image=new ImageIcon("stafff.png");
    }
    public staff(int x, int y) {
        super(15, 80, 7, "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images");
        
this.image=new ImageIcon("stafff.png");
    }
    public String toString(){
        return "Staff";
    }
}

 
