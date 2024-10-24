
import javax.swing.ImageIcon;

public class gun extends weapons{
    


    private ImageIcon image;
    public gun (){
 super(15, 80, 7, "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images");    }
    public gun (int d, int du, int dp){
        super(100,2,200);
        this.image=new ImageIcon("gun.png");
    }
    public gun(int x, int y) {
        super(15, 80, 7, "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images");
        
this.image=new ImageIcon("gun.png");
    }
    public String toString(){
        return "gun";
    }

}

 
