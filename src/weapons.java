
import java.awt.Image;

public class weapons {
    int dam , duribilty , dps;
    private Image image;
    public weapons(int par, int par1, int par2, String cUsersDemonDesktopganneerpggameeimageswea){

    }
    public weapons(int d, int du, int dp){
        dam=d;
        duribilty=du;
        dps=dp;
    }

public int getDam(){
    return this.dam;
}
public void setDamage(int damage) {
        this.dam = damage;
}
public int getDur(){
    return this.duribilty;
}
 public void setDurability(int durability) {
        this.duribilty = durability;
}
public int getDps(){
    return this.dps;
}
 public void setDps(int dps) {
        this.dps = dps;
       }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


  
    