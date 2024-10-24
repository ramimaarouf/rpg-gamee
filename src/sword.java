import javax.swing.ImageIcon;

public class sword extends weapons{
    


    private ImageIcon image;
    public sword (){
 super(15, 80, 7, "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images");    }
    public sword (int d, int du, int dp){
        super(100,2,200);
        this.image=new ImageIcon("twinblade.png");
    }
    public sword(int x, int y) {
        super(15, 80, 7, "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images");
        
this.image=new ImageIcon("sword.png");
    }
    public String toString(){
        return "sword";
    }

}

 
