import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener,

        MouseMotionListener {

    private BufferedImage back;

    private int key, x, y;

    private ArrayList<Characters> charList;
    public String screen;
    private Characters player;
    private Queue <Enemy> enemies;

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
        enemies=setEs();

    }
    public Queue<Enemy> setEs(){
        Queue<Enemy> temp = new LinkedList<>();
temp.add (new Alien (100,100));
temp.add (new Alien (300,100));
temp.add (new Alien (400,100));
return temp;
    }

    public ArrayList<Characters> setCharList() {
        ArrayList<Characters> temp = new ArrayList<Characters>();

    temp.add(new cory(250, 400,new twinblade(10, 20, 30))); 
    temp.add(new rami(600, 400, new sword(15, 80, 7)));
    temp.add(new bob(950, 400, new gun(10, 20, 30)));
    temp.add(new jack(1300, 400, new staff(10, 20, 30)));
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
        g2d.setColor(Color.WHITE); 
if ("character1".equals(screen)) {
    g2d.setColor(Color.YELLOW); 
    g2d.drawString("Character Name: Cory", 100, 110);        
    g2d.drawString("Health: " + player.getHea(), 100, 160);
        g2d.drawString("Speed: " + player.getSp(), 100, 210);
        g2d.drawString("Stamina: " + player.getStam(), 100, 260);
        g2d.drawString("Damage: " + player.getDam(), 100, 310);
    } else if ("character2".equals(screen)) {
        g2d.setColor(Color.YELLOW);
        g2d.drawString("Character Name: Rami", 100, 110);
        g2d.drawString("Health: " + player.getHea(), 100, 160);
        g2d.drawString("Speed: " + player.getSp(), 100, 210);
        g2d.drawString("Stamina: " + player.getStam(), 100, 260);
        g2d.drawString("Damage: " + player.getDam(), 100, 310);
    } else if ("character3".equals(screen)) {
        g2d.setColor(Color.YELLOW);
        g2d.drawString("Character Name: Bob", 100, 110);
        g2d.drawString("Health: " + player.getHea(), 100, 160);
        g2d.drawString("Speed: " + player.getSp(), 100, 210);
        g2d.drawString("Stamina: " + player.getStam(), 100, 260);
        g2d.drawString("Damage: " + player.getDam(), 100, 310);
    }else if ("character4".equals(screen)) {
            g2d.setColor(Color.YELLOW);
            g2d.drawString("Character Name: Jack", 100, 110);
            g2d.drawString("Health: " + player.getHea(), 100, 160);
            g2d.drawString("Speed: " + player.getSp(), 100, 210);
            g2d.drawString("Stamina: " + player.getStam(), 100, 260);
            g2d.drawString("Damage: " + player.getDam(), 100, 310);
    } else {
        g2d.drawString("Hello, Select a character!", 300, 300);
    }
    for (Characters c : charList) {
        c.drawChar(g2d);  
    }
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
break;

case "character1":
    drawCharacter1(g2d);
    break;
    case "character2":
    drawCharacter2(g2d);
    break;
    case "character3":
    drawCharacter3(g2d);
    break;
    case "character4":
    drawCharacter4(g2d);
    break;
    case "levelselection":
    drawLevelSelection(g2d);
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

private void drawCharacter1(Graphics g2d) {
    if (player != null) {
        player.drawChar(g2d);
        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.setColor(Color.YELLOW); // Set the text color to yellow
        g2d.drawString("Character 1 Screen", 100, 100);
        g2d.drawString("Character Name: " + player.toString(), 100, 130);
        g2d.drawString("Character Name: " + player.toString(), 100, 130);
        g2d.drawString("Health: " + player.getHea(), 100, 160);
        g2d.drawString("Speed: " + player.getSp(), 100, 190);
        g2d.drawString("Stamina: " + player.getStam(), 100, 220);
        g2d.drawString("Damage: " + player.getDam(), 100, 250);
         weapons weapons = player.getWeapon();
            if (weapons != null) {
                g2d.drawString("Weapon Damage: " + weapons.getDam(), 100, 280);
                g2d.drawString("Weapon Durability: " + weapons.getDurability(), 100, 310);
                g2d.drawString("Weapon DPS: " + weapons.getDps(), 100, 340);
            }
    }
}
    private void drawCharacter2(Graphics g2d) {
        if (player != null) {
            player.drawChar(g2d);
            g2d.setFont(new Font("Arial", Font.PLAIN, 20));
            g2d.setColor(Color.YELLOW); // Set the text color to yellow
            g2d.drawString("Character 2 Screen", 100, 100);
            g2d.drawString("Character Name: " + player.toString(), 100, 130);
            g2d.drawString("Character Name: " + player.toString(), 100, 130);
            g2d.drawString("Health: " + player.getHea(), 100, 160);
            g2d.drawString("Speed: " + player.getSp(), 100, 190);
            g2d.drawString("Stamina: " + player.getStam(), 100, 220);
            g2d.drawString("Damage: " + player.getDam(), 100, 250);
}
    }
private void drawCharacter3(Graphics g2d) {
    if (player != null) {
        player.drawChar(g2d);
        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.setColor(Color.YELLOW); // Set the text color to yellow
        g2d.drawString("Character 3 Screen", 100, 100);
        g2d.drawString("Character Name: " + player.toString(), 100, 130);
        g2d.drawString("Character Name: " + player.toString(), 100, 130);
        g2d.drawString("Health: " + player.getHea(), 100, 160);
        g2d.drawString("Speed: " + player.getSp(), 100, 190);
        g2d.drawString("Stamina: " + player.getStam(), 100, 220);
        g2d.drawString("Damage: " + player.getDam(), 100, 250);
}
}
private void drawCharacter4(Graphics g2d) {
    if (player != null) {
        player.drawChar(g2d);
        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.setColor(Color.YELLOW); // Set the text color to yellow
        g2d.drawString("Character 4 Screen", 100, 100);
        g2d.drawString("Character Name: " + player.toString(), 100, 130);
        g2d.drawString("Character Name: " + player.toString(), 100, 130);
        g2d.drawString("Health: " + player.getHea(), 100, 160);
        g2d.drawString("Speed: " + player.getSp(), 100, 190);
        g2d.drawString("Stamina: " + player.getStam(), 100, 220);
        g2d.drawString("Damage: " + player.getDam(), 100, 250);
}
}
private void drawLevelSelection(Graphics g2d){
    g2d.setColor(Color.YELLOW);
    g2d.drawString("Level Selection", 100, 100);
    g2d.drawString("Press 1 for Level 1", 100, 130);
    g2d.drawString("Press 2 for Level 2", 100, 160);
    g2d.drawString("Press 3 for Level 3", 100, 190);
}
    

    public static void main(String[] args) {
        JFrame frame = new JFrame("RPG Game");
        frame.setSize(1600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Game());
        frame.setVisible(true);
    
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
        System.out.println("Key pressed: " + key);

        System.out.println(key);
        if (key == 49) { 
            screen = "character1";
            player = charList.get(0);
            System.out.println("Screen switched to: " + screen);
            repaint();  
        } else if (key == 50) {
            screen = "character2";
            player = charList.get(1);
            System.out.println("Screen switched to: " + screen);
            repaint();  
        } else if (key == 51) {
            screen = "character3";
            player = charList.get(2);
            System.out.println("Screen switched to: " + screen);
            repaint();  
    } else if (key == 52) {
        screen = "character4";
        player = charList.get(3);
        System.out.println("Screen switched to: " + screen);
        repaint();  
            }else if  (screen.startsWith("character")){
                if(key==53){
                    screen="levelselection";
                    System.out.println("screen switched to: "+screen);
                    repaint();
                }
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
