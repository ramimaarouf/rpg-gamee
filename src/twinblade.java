import javax.swing.ImageIcon;

public class twinblade extends weapons{
    


    private ImageIcon image;
    public twinblade (){
 super(15, 80, 7, "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images");    }
    public twinblade (int d, int du, int dp){
        super(100,2,200);
        this.image=new ImageIcon("twinblade.png");
    }
    public twinblade(int x, int y) {
        super(15, 80, 7, "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images");
        
this.image=new ImageIcon("twinblade.png");
    }
    public String toString(){
        return "twinblade";
    }

}

 
