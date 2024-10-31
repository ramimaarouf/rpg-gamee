import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener,

        MouseMotionListener {

    private BufferedImage back;
    private boolean alienStatsPrinted = false;
    private Background background;
    private int key, x, y;

    private ArrayList<Characters> charList;
    private String screen="levelselection";
    private Characters player;
    private Queue <Enemy> enemies;

    private ArrayList<weapons> weaponsList;
    
    public Game() {
background= new Background();
        weaponsList = setWeaponList();

       
        
        new Thread(this).start();

        this.addKeyListener(this);

        this.addMouseListener(this);

        this.addMouseMotionListener(this);

        key = -1;

        x = 0;

        y = 0;

        charList = setCharList();
        System.out.println(charList.size());
    

        for (Iterator<Characters> it = charList.iterator(); it.hasNext();) {
            Characters c = it.next();
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

    temp.add(new cory(250, 400)); 
    temp.add(new rami(600, 400));
    temp.add(new bob(950, 400));
    temp.add(new jack(1300, 400));
        System.out.println(temp.size());
        return temp;
    }
public ArrayList<weapons> setWeaponList() {
        ArrayList<weapons> temp = new ArrayList<weapons>();
        ArrayList weaponsList = new ArrayList<>();
        temp.add(new twinblade(10, 20, 30, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\twinblade.png")));
        temp.add(new sword(15, 80, 7, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\sword.png")));
        temp.add(new gun(10, 20, 30));
        temp.add(new staff(10, 20, 30 , new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\staff.png")));
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
        background.draw(g2d, getWidth(), getHeight());

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
 }else if("weaponselection".equals(screen)){
        g2d.setColor(Color.GREEN);
        g2d.drawString("Weapon Selection", 100, 100);
        g2d.drawString("Press 5 for Twinblade", 100, 300);
        g2d.drawString("Press 6 for Sword", 800, 300);
        g2d.drawString("Press 7 for Gun", 800, 240);
        g2d.drawString("Press 8 for Staff", 100, 240);
        int[][] weaponPositions = {
            {100, 350}, 
            {300, 350}, 
            {500, 350}, 
            {700, 350}  
        };
    
        int weaponWidth = 100; 
        int weaponHeight = 100; 
    
        for (int i = 0; i < weaponsList.size(); i++) {
            weapons weapon = weaponsList.get(i);
            int x = weaponPositions[i][0];
            int y = weaponPositions[i][1];
            g2d.drawImage(weapon.getImage(), x, y, weaponWidth, weaponHeight, null);
        }
    } else if ("twinblade".equals(screen)) {
        drawTwinbladeScreen(g2d);
    } else if ("sword".equals(screen)) {
        drawSwordScreen(g2d);
    } else if ("gun".equals(screen)) {
        drawGunScreen(g2d);
    } else if ("staff".equals(screen)) {
        drawStaffScreen(g2d);
    }else if ("levelselection".equals(screen)) {
        drawLevelSelection(g2d);
    } else {
        g2d.drawString("Hello, Select a character!", 300, 300);
    }
    if (!"weaponselection".equals(screen)) {
    for (Characters c : charList) {
        c.drawChar(g2d);  
    }
}


    
    twoDgraph.drawImage(back, null, 0, 0);
    drawScreens(g2d);
    
    }

    
    private void drawBackground(Graphics g2d) {
        background.draw(g2d, getWidth(), getHeight());
    }

private void drawScreens(Graphics g2d) {
    if ("character1".equals(screen)) {
        drawCharacter1(g2d);
    } else if ("character2".equals(screen)) {
        drawCharacter2(g2d);
    } else if ("character3".equals(screen)) {
        drawCharacter3(g2d);
    } else if ("character4".equals(screen)) {
        drawCharacter4(g2d);
    } else if ("weaponselection".equals(screen)) {
        drawWeaponSelectionScreen(g2d);
    } else if ("twinblade".equals(screen)) {
        drawTwinbladeScreen(g2d);
        return;
    } else if ("sword".equals(screen)) {
        drawSwordScreen(g2d);
        return;
    } else if ("gun".equals(screen)) {
        drawGunScreen(g2d);
        return;
    } else if ("staff".equals(screen)) {
        drawStaffScreen(g2d);
        return;
    } else if ("levelselection".equals(screen)) {
        drawLevelSelection(g2d);
    }else{
    g2d.drawString("Hello, Select a character!", 300, 300);
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
        g2d.setColor(Color.YELLOW); 
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
        g2d.setColor(Color.YELLOW); 
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

private void drawWeaponSelectionScreen(Graphics g2d) {
    g2d.setFont(new Font("Arial", Font.BOLD, 50));
    g2d.setColor(Color.YELLOW);
    g2d.drawString("Pick your weapon", 100, 100);
}
private void drawTwinbladeScreen(Graphics g2d) {
    weapons twinblade = weaponsList.get(0); 
    g2d.setColor(Color.YELLOW);
    g2d.drawImage(twinblade.getImage(), 100, 100, 100, 100, null);
    g2d.drawString("Twinblade Info:", 100, 300);
    g2d.drawString("Damage: " + twinblade.getDam(), 100, 330);
    g2d.drawString("Durability: " + twinblade.getDurability(), 100, 360);
    g2d.drawString("DPS: " + twinblade.getDps(), 100, 390);
}
private void drawSwordScreen(Graphics g2d) {
    weapons sword = weaponsList.get(1); 
    g2d.setColor(Color.YELLOW);
    g2d.drawImage(sword.getImage(), 100, 100, 100, 100, null);
    g2d.drawString("Sword Info:", 100, 300);
    g2d.drawString("Damage: " + sword.getDam(), 100, 330);
    g2d.drawString("Durability: " + sword.getDurability(), 100, 360);
    g2d.drawString("DPS: " + sword.getDps(), 100, 390);
}
private void drawGunScreen(Graphics g2d) {
    weapons gun = weaponsList.get(2);
    g2d.setColor(Color.YELLOW);
    g2d.drawImage(gun.getImage(), 100, 100, 100, 100, null);
    g2d.drawString("Gun Info:", 100, 300);
    g2d.drawString("Damage: " + gun.getDam(), 100, 330);
    g2d.drawString("Durability: " + gun.getDurability(), 100, 360);
    g2d.drawString("DPS: " + gun.getDps(), 100, 390);
}
private void drawStaffScreen(Graphics g2d) {
    weapons staff = weaponsList.get(3); 
    g2d.setColor(Color.YELLOW);
    g2d.drawImage(staff.getImage(), 100, 100, 100, 100, null);
    g2d.drawString("Staff Info:", 100, 300);
    g2d.drawString("Damage: " + staff.getDam(), 100, 330);
    g2d.drawString("Durability: " + staff.getDurability(), 100, 360);
    g2d.drawString("DPS: " + staff.getDps(), 100, 390);
}
private void printAlienStats(Enemy alien) {
    System.out.println("Alien Stats:");
    System.out.println("Health: " + alien.getHealth());
    System.out.println("Speed: " + alien.getSpeed());
    System.out.println("Damage: " + alien.getDamage());
}
private void swingSword() {
    System.out.println("Swinging the sword!");
}
private void drawLevelSelection(Graphics g2d) {
    background.draw(g2d, getWidth(), getHeight());
    g2d.setColor(Color.YELLOW);
    g2d.drawString("Level Selection", 100, 100);
    g2d.drawString("Press x for Level 1", 100, 130);

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
        key = e.getKeyCode();
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
        } else if (screen.startsWith("character") && key == KeyEvent.VK_0) {
            screen = "weaponselection";
            System.out.println("Screen switched to: " + screen);
            repaint();
        }else if (key == 53) {
            screen = "twinblade";
            System.out.println("Screen switched to: " + screen);
            repaint();
        } else if (key == 54) {
            screen = "sword";
            System.out.println("Screen switched to: " + screen);
            repaint();
        } else if (key == 55) {
            screen = "gun";
            System.out.println("Screen switched to: " + screen);
            repaint();
        } else if (key == 56) {
            screen = "staff";
            System.out.println("Screen switched to: " + screen);
            repaint();
        }   else if (key == KeyEvent.VK_F) {
            swingSword();
        }else if (key == KeyEvent.VK_X) {
            screen = "levelselction";
            System.out.println("Screen switched to: " + screen);
            repaint();
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
