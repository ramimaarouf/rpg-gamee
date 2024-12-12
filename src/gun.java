import javax.swing.ImageIcon;

public class gun extends weapons {
    public gun(int damage, int durability, int dps) {
        super(damage, durability, dps, "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\gun.png");
}

public gun(int x, int y, int i, ImageIcon imageIcon) {
        super(15, 80, 7, "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\gun.png");
    }
}