import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;

public class Pyroflora extends Planets implements KeyListener {
    private BufferedImage back;
    private String screen = "Planet2"; 
    private Characters player;
    private ArrayList<Characters> charList;
    private Queue<Enemy> oppenents;
    private boolean alienStatsPrinted = false;

    // Parameterized constructor
    public Pyroflora(String name, String imagePath) {
        super(name, imagePath);
        initializeComponents();
    }

    private void initializeComponents() {
        this.charList = new ArrayList<>();
        this.oppenents = new LinkedList<>();
       try{
        back=ImageIO.read(new File("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\pyroflora.png"));
       }catch(IOException e){
           e.printStackTrace();
       }
    }
public void drawBackground (Graphics g){
    g.drawImage(back, 0, 0, null);
}
public void setOppenents(){
    oppenents.add(new Alien(100, 100));
    oppenents.add(new Alien(200, 200));
    oppenents.add(new Alien(300, 300));
    oppenents.add(new Alien(400, 400));
}
public void drawOppenents(Graphics g){
    for(Enemy oppenent: oppenents){
        oppenent.draw(g);
    }
}
    // KeyListener methods
    @Override
    public void keyPressed(KeyEvent e) {
        // Handle key events
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key released
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key typed
    }

    // Other methods...
}