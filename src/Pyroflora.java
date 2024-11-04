import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Pyroflora extends Planets implements KeyListener {
    private BufferedImage back;
    private String screen = "Planet2"; 
    private Xylaris xylaris;
    private Characters player;
    private ArrayList<Characters> charList;
    private ArrayList<Enemy> enemies;
    private boolean alienStatsPrinted = false;

    public Pyroflora (){
    ImageIcon backgroundImage = new ImageIcon("path/to/pyroflora/background/image.png");
    this.charList=new ArrayList<>();
    this.enemies=new ArrayList<>();
  
   


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
                                            
                                                    g2d.drawImage(backgroundImage.getImage(), 0, 0, null);
                                            
                                                    if (player != null) {
                                                        player.drawChar(g2d);
                                                    }
                                            
                                                    for (Enemy alien : enemies) {
                                                        alien.drawChar(g2d);
                                                    }
                                            
                                                    twoDgraph.drawImage(back, null, 0, 0);
                                                }
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                                private BufferedImage createImage(Object width, Object height) {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'createImage'");
                }
            
            
            
            
            
            
            
            
            
            
            
            
                                                private Object getWidth() {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'getWidth'");
                }
            
            
            
            
            
            
            
            
            
            
            
            
                                    private Object getHeight() {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'getHeight'");
                }
            
            
            
            
            
            
            
            
            
            
            
            
                        private Dimension getSize() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getSize'");
            }
        
        
        
        
        
        
        
        
        
        
        
        
            public void xylarisMethod() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'xylarisMethod'");
    }
}