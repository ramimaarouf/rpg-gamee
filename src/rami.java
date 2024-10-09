import javax.swing.ImageIcon;
public class rami extends Characters {
    public rami (){
super();
    }
    public rami (int x, int y){
        super(x,y,50,50,300,500,15,1000,new ImageIcon("rami.png"));
    }
    public String toString(){
        return "rami"+ super.getHealth();
    }
    }
