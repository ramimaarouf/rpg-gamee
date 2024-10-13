import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener,

        MouseMotionListener {

    private BufferedImage back;

    private int key, x, y;

    private ArrayList<Characters> charList;
    public String screen;
    private Characters player;

    public Game() {

        new Thread(this).start();

        this.addKeyListener(this);

        this.addMouseListener(this);

        this.addMouseMotionListener(this);

        key = -1;

        x = 0;

        y = 0;

        charList = setCharList();
        System.out.println(charList.size());
    

        for (Characters c : charList) {

            System.out.println(c);

        }
        screen="start";

    }

    public ArrayList<Characters> setCharList() {
        ArrayList<Characters> temp = new ArrayList<Characters>();

    temp.add(new cory(250, 100)); 
    temp.add(new rami(400, 100)); 
    temp.add(new bob(550, 100));  
    temp.add(new jack(600, 100)); 
        System.out.println(temp.size());
        return temp;

    }
    

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(5);
                repaint();
            }
        } catch (Exception e) {
        }
    }

    public void paint(Graphics g) {
        Graphics2D twoDgraph = (Graphics2D) g;
        if (back == null)

            back = (BufferedImage) ((createImage(getWidth(), getHeight())));

        Graphics g2d = back.createGraphics();

        g2d.clearRect(0, 0, getSize().width, getSize().height);

        g2d.setFont(new Font("Broadway", Font.BOLD, 50));

        g2d.drawString("Hello!", x, y);

        twoDgraph.drawImage(back, null, 0, 0);
        drawScreens(g2d);

    }

    private void drawScreens(Graphics g2d) {
        // TODO Auto-generated method stub
       switch(screen){
        case "start":
        drawStartScreen(g2d);
          break;
        case "selection":
        drawSelectScreen(g2d);

       }
       
    }

    private void drawSelectScreen(Graphics g2d) {
        player.drawChar(g2d);
      g2d.drawString("You picked"+player.toString(),200,500 );

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawSelectScreen'");
    }

    private void drawStartScreen(Graphics g2d) {
for(Characters c: charList){
    c.drawChar(g2d);
   
}

}



    // DO NOT DELETE
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    // DO NOT DELETE
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        key = e.getKeyCode();

        System.out.println(key);
        if(key==32){
            screen="selection";
            player=charList.get(1);
        }

    }

    // DO NOT DELETE
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub

        x = arg0.getX();
        y = arg0.getY();
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("entered");

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("exited");

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("you clicked at" + arg0.getY());
        x = arg0.getX();
        y = arg0.getY();

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }
}