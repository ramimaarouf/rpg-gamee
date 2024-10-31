import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Xylaris extends JPanel implements KeyListener {
    private BufferedImage back;
    private String screen = "Planet1"; 
    private Xylaris xylaris;
    private Characters player;
    private ArrayList<Characters> charList;
    private ArrayList<Enemy> enemies;
    private boolean alienStatsPrinted = false;

    public Xylaris (){
    ImageIcon backgroundImage = new ImageIcon("path/to/xylaris/background/image.png");
    this.charList=new ArrayList<>();
    this.enemies=new ArrayList<>();
   addKeyListener(this);
    setFocusable(true);
   


}

    
    
    
    
    
    
    
    
    
    
    
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    public void paint(Graphics g, ImageIcon backgroundImage) {
        Graphics2D twoDgraph = (Graphics2D) g;
        if (back == null) {
            back = (BufferedImage) ((createImage(getWidth(), getHeight())));
        }

        Graphics g2d = back.createGraphics();
        g2d.clearRect(0, 0, getSize().width, getSize().height);

        g2d.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);

        if (player != null) {
            player.drawChar(g2d);
        }

        for (Enemy alien : enemies) {
            alien.drawChar(g2d);
        }

        twoDgraph.drawImage(back, null, 0, 0);
    }
}