import javax.swing.ImageIcon;

public class cory extends Characters {
    public cory() {
        super();
    }

    public cory(int x, int y) {
        super(x, y, 300, 300, 40, 20, 15, 1000, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\cory.png"));
    }
    public String toString(){
        return "cory"+ super.getHea() + " " + super.getDam() + " " + super.getStam()+" " + super.getSp();
    }
}