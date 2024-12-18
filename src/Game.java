import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.TimerTask;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Target;
import java.util.Timer;
import javax.swing.*;
import java.util.List;
import javax.xml.namespace.QName;



public class Game extends JPanel implements Runnable, KeyListener, MouseListener,

        MouseMotionListener {
    private BufferedImage back;
    private boolean alienStatsPrinted = false;
    private Background background;
    private int key, x, y;
    private Background xylarisBackground;
    private Background pyrofloraBackground;
    private boolean gameOver = false;
private int playerScore = 0;
private boolean isAttacking = false;
private int index;
private long lastClickTime = 0;
private long cooldownTime = 500; 
private boolean dpsBoostActive = false;
private boolean moveUp = false;
private boolean moveDown = false;
private boolean moveLeft = false;
private boolean moveRight = false;
    private ArrayList<Characters> charList;
    private Random random = new Random();
    private String screen="levelselection";
    private Characters player;
    private Queue <Enemy> enemies;
    private Queue<Enemy> enemyQueue2;
    private boolean characterSelected = false;
    private Enemy currentEnemy;
    private Enemy currentEnemy2;
    private Planets selectedPlanet;
    private weapons selectedWeapon = null;
    private ArrayList<weapons> weaponsList;
    private ArrayList<Planets> planetList;
    private ArrayList<Projectile> projectiles;
        private List<Target> targets;
private Queue<Enemy> enemyQueue;
private File saveFile;
private static final String SAVE_FILE = "save.txt";
private List <Ranged> eProjectiles;
private List <Ranged> eMissiles;
    private Character Character;
    private List<Melee> Melee;
    private List<Projectile> aMissiles;
    private String cat;
public Game(List<Ranged> eProjectiles, List<Ranged> eMissiles, Character player, int lives) {
    this.eProjectiles = eProjectiles;
    this.eMissiles = eMissiles;
    this.Character = player;
    //private int index;
   
}

public Game() {
    initializeGame();
    aMissiles=new ArrayList<>();
    enemyQueue2 = setEs2();
    background = new Background("C:\\Users\\Demon\\Desktop\\rpg-gamee\\images\\planett.png");
    xylarisBackground = new Background("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\xxxxx.png");
    pyrofloraBackground = new Background("C:\\Users\\Demon\\Desktop\\i give up\\rpg-gamee\\images\\ccc.png");
    weaponsList = setWeaponList();
{
        saveFile=new File("save.txt");
        new Thread(this).start();
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        saveScreenState();
    }));

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
        if (charList.size() > 0 && weaponsList.size() > 0) {
            charList.get(0).setWeapon(weaponsList.get(0)); 
            if (charList.size() > 1 && weaponsList.size() > 1) {
                charList.get(1).setWeapon(weaponsList.get(1)); 
                if (charList.size() > 2 && weaponsList.size() > 2) {
                    charList.get(2).setWeapon(weaponsList.get(2)); 
                    if (charList.size() > 3 && weaponsList.size() > 3) {
                        charList.get(3).setWeapon(weaponsList.get(3)); 
                    }
                }
            }
        }
        
        screen="start";
        enemies=setEs();
        enemyQueue2 = setEs2();
        index = 0;
cat="chose your weapon";
    }
}

public void initializeGame() {
    enemyQueue = setEs();
    enemyQueue2 = setEs2();
    currentEnemy = null;
    currentEnemy2 = null;
    player = new Characters();
    playerScore = 0;
}
public void createFile() {
try {
    if(saveFile.createNewFile()) {
        System.out.println("created file");
    } else {
        System.out.println("file already exists");
    }
} catch (IOException e) {
    //TODO Auto-generated catch block
    e.printStackTrace();
}
}
public void readFile() throws FileNotFoundException{
    Scanner sc = null;
try {
    sc = new Scanner(saveFile);
    while(sc.hasNext()){        
        System.out.println(sc.next());
    }
} catch (FileNotFoundException ex) {
    ex.printStackTrace();

}
}
public void writeToFile() throws IOException {
    FileWriter myWriter =new FileWriter (saveFile);

    if(enemies.isEmpty()){
        myWriter.write("win");

    }
    else{
        myWriter.write("You have" + enemies.size() + "enemies left");
    }
    myWriter.close();

    System.out.println("Successfully wrote to the file");
}void cathch (IOException e){
    e.printStackTrace();
}

private void saveScreenState() {
    try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_FILE))) {
        writer.println("Screen: " + screen);
        writer.println("Score: " + playerScore);
        System.out.println("Game state saved successfully.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void loadScreenState() {
    try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
        String screenLine = reader.readLine();
        String scoreLine = reader.readLine();
        
        if (screenLine != null && scoreLine != null) {
            screen = screenLine.split(": ")[1];
            playerScore = Integer.parseInt(scoreLine.split(": ")[1]);
            System.out.println("Screen state and score loaded: " + screen + ", " + playerScore);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public boolean enemyHit() {
    if (!enemies.isEmpty()) {
        Enemy enemy = enemies.peek(); // Check the next enemy in the queue
        if (enemy.getBounds().contains(x, y)) { // Check collision using mouse position
            return true;
        }
    }
    return false;
}
        
    
public boolean checkPlayerHit() {
    Iterator<Projectile> iterator = aMissiles.iterator();
    while (iterator.hasNext()) {
        Projectile missile = iterator.next();
        if (player.getX() < missile.getX() + missile.getWidth() &&
            player.getX() + player.getW() > missile.getX() &&
            player.getY() < missile.getY() + missile.getHeight() &&
            player.getY() + player.getH() > missile.getY()) {
            iterator.remove();
            player.setHea(player.getHea() - 25); 
            if (player.getHea() <= 0) {
                player.setHea(0); 
    System.out.println("Player health is 0. Game over.");
                System.out.println("player health is " + player.getHea());
                player.setHea(0);
                screen = "GameLostScreen";
                repaint();
            }
            return true;
        }
    }
    return false;
}
    
public Characters getSelectedCharacter() {
    return player;
}

public weapons getSelectedWeapon() {
    return player != null ? player.getWeapon() : null;
}

    public Queue<Enemy> setEs(){
        Queue<Enemy> temp = new LinkedList<>();
temp.add (new Alien (1000,470));
temp.add (new Alien (1000,300));
temp.add (new Alien (1000,500));
temp.add (new Alien (1000,500));
temp.add (new Alien (1000,500));
temp.add (new Alien (1000,500));
temp.add (new Alien (1000,500));
temp.add(new AlienBoss(1000, 500));
return temp;
    }
    public Queue<Enemy> setEs2() {
        Queue<Enemy> temp = new LinkedList<>();
        temp.add(new LavaAliens(1200, 470));
        temp.add(new LavaAliens(1200, 300));
        temp.add(new LavaAliens(1200, 500));
        temp.add(new LavaAliens(1200, 500));
        temp.add(new LavaAliens(1200, 500));
        temp.add(new LavaAliens(1200, 500));
        temp.add(new LavaAliens(1200, 500));
        temp.add(new LavaBoss(1200, 500));
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
        temp.add(new twinblade(10, 1, 30, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\twinblade.png")));
        temp.add(new sword(15, 80, 7, new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\sword.png")));
        temp.add(new gun(10, 20, 30));
        temp.add(new staff(10, 20, 30 , new ImageIcon("C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\staff.png")));
    System.out.println(temp.size());
        return temp;
    }
    public ArrayList<Planets> setPlanetList() {
        ArrayList<Planets> temp = new ArrayList<>();
        temp.add(new Xylaris("Xylaris", "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\xxxxx.png"));
        temp.add(new Pyroflora("Pyroflora", "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\ccc.png"));
        System.out.println(temp.size());
        return temp;
    }
    public ArrayList<Projectile> setProjectileList() {
        ArrayList<Projectile> temp = new ArrayList<>();
        new Projectile(100, 100, 10, "MISSLEE", "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\MISSLEE.png");
        new Projectile(100, 100, 10, "MISSLEE", "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\MISSLEE.png");
        new Projectile(100, 100, 10, "MISSLEE", "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\MISSLEE.png");
        new Projectile(100, 100, 10, "MISSLEE", "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\MISSLEE.png");
        System.out.println(temp.size());
        return temp;
    }
    public void addProjectile(int x, int y, int speed, String name, String imagePath) {
        projectiles.add(new Projectile(x, y, speed, name, imagePath));
    }
    public void run() {
        try {
            while (true) {
                boolean isMoving = false;
    
                if (moveUp && player != null) {
                    player.move(0, -5);
                    isMoving = true;
                }
                if (moveDown && player != null) {
                    player.move(0, 5);
                    isMoving = true;
                }
                if (moveLeft && player != null) {
                    player.move(-5, 0);
                    isMoving = true;
                }
                if (moveRight && player != null) {
                    player.move(5, 0);
                    isMoving = true;
                }
    
                if (!isMoving && player != null) {
                    player.regenerateStamina();
                }
    
                updateGameElements();
                checkPlayerHit();
                checkMissileCollisions();
                Thread.sleep(10);
                repaint();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    
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
g2d.drawString(cat.substring(0,index), 100, 400);
if(index < cat.length()){
    if(index<cat.length()){
        index++;
    }
}
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
    } else if ("XylarisScreen".equals(screen)) {
        drawXylarisScreen(g2d);





    } else if ("PyrofloraScreen".equals(screen)) {
        drawPyrofloraScreen(g2d);
    }

     if (!"levelselection".equals(screen) && !characterSelected)
    if (!"weaponselection".equals(screen)) {
    for (Characters c : charList) {
        
        c.drawChar(g2d);  
    }
    
}
drawAlienMissiles(g2d);


    twoDgraph.drawImage(back, null, 0, 0);
    drawScreens(g2d);
    }

    private void drawPlayerWeapon(Graphics2D g2d) {
        if (player.getWeapon() != null) {
            weapons weapon = player.getWeapon();
            int weaponX = player.getX() + 50;  
            int weaponY = player.getY();
            g2d.drawImage(weapon.getImage(), weaponX, weaponY, 50, 50, null);
        }
    }

    
    private void drawBackground(Graphics g2d) {
        background.draw(g2d, getWidth(), getHeight());
    }
    private void drawXylarisBackground(Graphics g2d) {
        xylarisBackground.draw(g2d, getWidth(), getHeight());
    }
    
    private void drawPyrofloraBackground(Graphics g2d) {
        pyrofloraBackground.draw(g2d, getWidth(), getHeight());
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
            }else if (screen.equals("levelselection")) {
                drawLevelSelection(g2d);
            } else if ("XylarisScreen".equals(screen)) {
                drawXylarisScreen(g2d);
            } else if ("PyrofloraScreen".equals(screen)) {
                drawPyrofloraScreen(g2d);
            }else if ("GameLostScreen".equals(screen)) {
                drawGameLostScreen(g2d);
            }if ("inventory".equals(screen)) {
                drawInventoryScreen(g2d);
            }
        }
        
            private void drawSelectScreen(Graphics g2d) {
        player.drawChar(g2d);
      g2d.drawString("You picked"+player.toString(),200,500 );

            }
            private void drawPlanets(Graphics g2d) {
                
            

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
    g2d.setFont(new Font("Arial", Font.BOLD, 30)); 
    g2d.drawString("Select Your Planet:", 100, 100);
    g2d.drawString(" 'space' Xylaris - The Crystal World", 100, 200);
    g2d.drawString(" 'c'  Pyroflora - The Burning Planet", 100, 250);
}

private void drawXylarisScreen(Graphics g2d) {
    drawXylarisBackground(g2d);
    g2d.setColor(Color.YELLOW);
    g2d.setFont(new Font("Arial", Font.BOLD, 30));
    //System.out.println("Health is " + player.getHea());
    if (player != null) {
        player.drawChar(g2d);
        weapons playerWeapon = player.getWeapon();

        if (playerWeapon != null) {
            playerWeapon.setX(player.getX() + 50);
            playerWeapon.setY(player.getY());
            g2d.drawImage(playerWeapon.getImage(), playerWeapon.getX(), playerWeapon.getY(), 50, 50, null);
        }
        g2d.setColor(Color.WHITE);
        g2d.drawString("Health: " + player.getHea(), 1500, 50);
        g2d.drawString("Stamina: " + player.getStam(), 800, 100);
    }

    if (currentEnemy == null || currentEnemy.isKilled()) {
        if (!enemyQueue.isEmpty()) {
            currentEnemy = enemyQueue.poll();
            currentEnemy.setPosition(500, 500); 
        }
    }

    if (currentEnemy != null) {
        currentEnemy.draw(g2d);
        g2d.setColor(Color.RED);
        g2d.drawString("Enemy Health: " + currentEnemy.getHealth(), 1400, 75);
    }

    g2d.setColor(Color.WHITE);
    g2d.drawString("Score: " + playerScore, 50, 50);

    if (player instanceof rami && playerScore >= 30) {
        g2d.setColor(Color.GREEN);
        g2d.drawString("Special Ability Ready! Press 'G' to use.", 50, 100);
    }
    if (player instanceof bob && playerScore >= 30) {
        g2d.setColor(Color.GREEN);
        g2d.drawString("Special Ability Ready! Press 'G' to use.", 50, 100);
        
    }
    if (player instanceof jack && playerScore >= 30) {
        g2d.setColor(Color.GREEN);
        g2d.drawString("Special Ability Ready! Press 'G' to use.", 50, 100);
    }
    if (player instanceof cory && playerScore >= 30) {
        g2d.setColor(Color.GREEN);
        g2d.drawString("Special Ability Ready! Press 'G' to use.", 50, 100);
    }
}

    
private void drawPyrofloraScreen(Graphics g2d) {
    drawPyrofloraBackground(g2d);
    drawAlienMissiles(g2d);
    g2d.setColor(Color.YELLOW);
    g2d.setFont(new Font("Arial", Font.BOLD, 30));

    if (player != null) {
        player.drawChar(g2d);
        weapons playerWeapon = player.getWeapon();

        if (playerWeapon != null) {
            playerWeapon.setX(player.getX() + 50);
            playerWeapon.setY(player.getY());
            g2d.drawImage(playerWeapon.getImage(), playerWeapon.getX(), playerWeapon.getY(), 50, 50, null);
        }
        g2d.setColor(Color.WHITE);
        g2d.drawString("Health: " + player.getHea(), 1500, 50);
   g2d.drawString("Stamina: " + player.getStam(), 800, 100);
    }

    if (currentEnemy2 == null || currentEnemy2.isKilled()) {
        if (!enemyQueue2.isEmpty()) {
            currentEnemy2 = enemyQueue2.poll();
            currentEnemy2.setPosition(700, 500); 
        }
    }

    if (currentEnemy2 != null) {
        currentEnemy2.draw(g2d);
        g2d.setColor(Color.RED);
        g2d.drawString("Enemy Health: " + currentEnemy2.getHealth(), 1400, 100);
    }
  

    g2d.setColor(Color.WHITE);
    g2d.drawString("Score: " + playerScore, 50, 50);

if (player instanceof rami && playerScore >= 30) {
        g2d.setColor(Color.GREEN);
        g2d.drawString("Special Ability Ready! Press 'G' to use.", 50, 100);
    }
    if (player instanceof bob && playerScore >= 30) {
        g2d.setColor(Color.GREEN);
        g2d.drawString("Special Ability Ready! Press 'G' to use.", 50, 100);
    }
    if (player instanceof jack && playerScore >= 30) {
        g2d.setColor(Color.GREEN);
        g2d.drawString("Special Ability Ready! Press 'G' to use.", 50, 100);
    }
    if (player instanceof cory && playerScore >= 30) {
        g2d.setColor(Color.GREEN);
        g2d.drawString("Special Ability Ready! Press 'G' to use.", 50, 100);
    }
}

private void drawGameLostScreen(Graphics g2d) {
    try {
        System.out.println("Entering drawGameLostScreen");

        // Fill the entire panel with black for visibility
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Set color to red and draw text
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial", Font.BOLD, 50));
        g2d.drawString("Game Over", getWidth() / 2 - 150, getHeight() / 2 - 25);

        g2d.setFont(new Font("Arial", Font.PLAIN, 30));
        g2d.drawString("Press 'R' to Restart", getWidth() / 2 - 150, getHeight() / 2 + 25);

        System.out.println("Drawing Game Over screen...");
    } catch (Exception e) {
        e.printStackTrace();
    }
}





    // DO NOT DELETE
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F) {
            isAttacking = false;
        }
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W:
                moveUp = false;
                break;
            case KeyEvent.VK_S:
                moveDown = false;
                break;
            case KeyEvent.VK_A:
                moveLeft = false;
                break;
            case KeyEvent.VK_D:
                moveRight = false;
                break;
        }
        repaint();
    }
    // DO NOT DELETE
    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        System.out.println(key);
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W:
                moveUp = true;
                break;
            case KeyEvent.VK_S:
                moveDown = true;
                break;
            case KeyEvent.VK_A:
                moveLeft = true;
                break;
            case KeyEvent.VK_D:
                moveRight = true;
                break;
        }
        if (key == 49) {
            screen = "character1";
            player = charList.get(0);
            characterSelected = true;
 System.out.println("Screen switched to: " + screen);
            repaint();
        } else if (key == 50) {
            screen = "character2";
            player = charList.get(1);
            characterSelected = true;
System.out.println("Screen switched to: " + screen);
            repaint();
        } else if (key == 51) {
            screen = "character3";
            player = charList.get(2);
            characterSelected = true;

            System.out.println("Screen switched to: " + screen);
            repaint();
        } else if (key == 52) {
            screen = "character4";
            player = charList.get(3);
            characterSelected = true;

            System.out.println("Screen switched to: " + screen);
            repaint();
        } else if (screen.startsWith("character") && key == KeyEvent.VK_0) {
            screen = "weaponselection";
            System.out.println("Screen switched to: " + screen);
            repaint();
        }else if (key == 53) {
            selectedWeapon = weaponsList.get(0);
            player.setWeapon(selectedWeapon);   
            screen = "XylarisScreen"; 
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
            isAttacking = true;
        }else if (key == KeyEvent.VK_X) {
            screen = "levelselection";
            System.out.println("Screen switched to: " + screen);
            repaint();
        } else if (key == KeyEvent.VK_SPACE) {
            screen = "XylarisScreen";
            System.out.println("Screen switched to: " + screen);
            repaint();
        }else if (key==KeyEvent.VK_P){
        
         } else if (key == KeyEvent.VK_C) {
            screen = "PyrofloraScreen";
            System.out.println("Screen switched to: " + screen);
            //repaint();
            }
            if (key == KeyEvent.VK_M) {
                loadScreenState(); 
                repaint(); 
            } else if (screen.equals("levelselection")) {
                if (key == KeyEvent.VK_1) {
                    System.out.println("Selected Level 1: Xylaris");
                    screen = "xylaris"; 
                    System.out.println("Screen switched to: " + screen);
                    repaint();
                }
            } else {
                if (key == KeyEvent.VK_X) {
                    screen = "levelselection";
                    System.out.println("Screen switched to: " + screen);
                  //  repaint();
                } else if (player.getHea() <= 0) {
                    screen = "GameLostScreen";
                    System.out.println("Drawing Game Over screen...");
                    System.out.println("Screen switched to: " + screen);
                 //   repaint();
                } else if (key == KeyEvent.VK_R) {
                    initializeGame();
                    screen = "SelectScreen";
                    System.out.println("Screen switched to: " + screen);
                    // repaint();
                    if (key == KeyEvent.VK_G && player instanceof rami && playerScore >= 30) {
                        ((rami) player).specialAbility();
                        System.out.println("Ability used");
                    } else if (key == KeyEvent.VK_H && player instanceof bob && playerScore >= 30) {
                        ((bob) player).specialAbility();
                        System.out.println("Ability used");
                    } else if (key == KeyEvent.VK_J && player instanceof cory && playerScore >= 30) {
                        ((cory) player).specialAbility();
                        System.out.println("Ability used");
                    } else if (key == KeyEvent.VK_K && player instanceof jack && playerScore >= 30) {
                        ((jack) player).specialAbility();
                        System.out.println("Ability used");
                    }else if (key == KeyEvent.VK_M) { // Inventory key
                        screen = "inventory";
                        repaint();
                    } else if (key == KeyEvent.VK_U) { // 'U' key to use the artifact
                    for (Item item : player.getInventory().getItems()) {
                        if (item instanceof AlienArtifact) {
                            if (item instanceof AlienArtifact) {
                                ((AlienArtifact) item).useArtifact(player);
                            }
                            player.getInventory().removeItem(item);
                            break;
                        }
                    }
                }
        }
    }
}   
    
        
    
        

    

    // DO NOT DELETE
@Override
public void mouseDragged(MouseEvent e) {
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
        if (selectedWeapon != null && selectedWeapon.equals(weaponsList.get(2))) { // Assuming gun is at index 2
            addProjectile(player.getX(), player.getY(), 5, "Projectile", "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\MISSLEE.png");
            System.out.println("Projectile fired at (" + player.getX() + ", " + player.getY() + ")");

        }
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
    public void mousePressed(MouseEvent e) {
    long currentTime = System.currentTimeMillis();
    if (currentTime - lastClickTime >= cooldownTime) {
        lastClickTime = currentTime;
        x = e.getX();
        y = e.getY();
        System.out.println("Mouse pressed at (" + x + ", " + y + ")");
        
        if (enemyHit()) {
            System.out.println("Enemy hit!");
            reduceEnemyHealth();
        }
    } else {
        System.out.println("Cooldown active. Please wait.");
    }

    if (player != null) {
        player.decreaseStamina(5); 
        System.out.println("Losing stamina due to mouse press. Current stamina: " + player.getStam());
    }
}
    

    

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

        
    private void removeEnemy() {
        if (currentEnemy != null && !enemies.isEmpty()) {
            enemies.remove();
            currentEnemy = null; 
            playerScore += 10;
            System.out.println("Enemy removed from first queue. Score: " + playerScore);
            if (enemies.isEmpty()) {
                System.out.println("All enemies in first queue defeated!");
            }
        } 
        
        if (currentEnemy2 != null && !enemyQueue2.isEmpty()) {
            enemyQueue2.remove();
            currentEnemy2 = null; 
            playerScore += 10;
            System.out.println("Enemy removed from second queue. Score: " + playerScore);
            if (enemyQueue2.isEmpty()) {
                System.out.println("All enemies in second queue defeated!");
                if (Math.random() < 0.2) { // 20% chance
                    AlienArtifact artifact = new AlienArtifact();
                    player.getInventory().addItem(artifact);
                    System.out.println("Alien Artifact dropped!");
                }
            }
        }
    }
    


public void getAlienMissile() {
    if (currentEnemy != null && aMissiles != null) {
        Random rand = new Random();
        int randomX = rand.nextInt(getWidth()); 
        Projectile missile = new Projectile(
            randomX, 
            currentEnemy.getY() + currentEnemy.getHeight(),
            5, 
            "Alien Missile",
            "C:\\Users\\Demon\\Desktop\\gannee\\rpg-gamee\\images\\MISSLEE.png"
        );
        aMissiles.add(missile);
        System.out.println("Missile added at random X: " + randomX);
    }
}
public void drawAlienMissiles(Graphics g2d) {
    if (aMissiles == null) {
        System.out.println("Missiles list is null!");
        
        return;
    }
   // System.out.println("Drawing missiles");

    
    for (Projectile am : aMissiles) {
        if (am != null) {
            am.draw(g2d);
        } else {
            System.out.println("Null missile in list");
        }
    }
}

private void updateMissiles() {
    Random rand = new Random();
        Iterator<Projectile> iterator = aMissiles.iterator();
        while (iterator.hasNext()) {
            Projectile am = iterator.next();
            int dx = rand.nextInt(11) - 5; 
            int dy = rand.nextInt(11) - 5; 
            am.setX(am.getX() + dx);
            am.setY(am.getY() + dy);

            if (am.getY() > getHeight() || am.getY() < 0 || am.getX() > getWidth() || am.getX() < 0) {
                iterator.remove();
            }
        }
    }
    private void handleEnemyShooting() {
        if (currentEnemy != null && random.nextInt(100) < 2) { // 2% chance
            getAlienMissile();
        }
    }
    public void actionPerformed(ActionEvent e) {
        handleEnemyShooting();
        updateMissiles();
        repaint();
    }
   @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (screen.equals("GameLostScreen")) {
            drawGameLostScreen(g);
        } else {
            if (screen.equals("xylaris")) {
                drawXylarisScreen(g);
            } else if (screen.equals("pyroflora")) {
                drawPyrofloraScreen(g);
            } else if (screen.equals("levelselection")) {
                drawLevelSelection(g);
            }
            drawAlienMissiles(g);
        }
    }
    private void updateGameElements() {
        handleEnemyShooting();
        updateMissiles();
        
    }
    private void checkMissileCollisions() {
        Iterator<Projectile> iterator = aMissiles.iterator();
        while (iterator.hasNext()) {
            Projectile missile = iterator.next();
            Rectangle missileBounds = missile.getBounds();

            if (currentEnemy != null && missileBounds.intersects(currentEnemy.getBounds())) {
                currentEnemy.setHealth(currentEnemy.getHealth() - player.getWeapon().getDamage());
                System.out.println("Hit first queue enemy. Health: " + currentEnemy.getHealth());
                if (currentEnemy.getHealth() <= 0) {
                    removeEnemy();
                }
                iterator.remove();
                break;
            }

            if (currentEnemy2 != null && missileBounds.intersects(currentEnemy2.getBounds())) {
                currentEnemy2.setHealth(currentEnemy2.getHealth() - player.getWeapon().getDamage());
                System.out.println("Hit second queue enemy. Health: " + currentEnemy2.getHealth());
                if (currentEnemy2.getHealth() <= 0) {
                    removeEnemy();
                }
                iterator.remove();
                break;
            }
        }
    }
    private void reduceEnemyHealth() {
        weapons playerWeapon = player.getWeapon();
        int damage = (playerWeapon != null) ? playerWeapon.getDamage() : 0;
    
        if (player instanceof rami && playerScore >= 30) {
            System.out.println("should be using extra dmg");
            ((rami) player).specialAbility();
            damage = playerWeapon.getDamage(); 
        }
    
        if (currentEnemy != null) {
            currentEnemy.setHealth(currentEnemy.getHealth() - damage);
            System.out.println("Enemy health reduced by " + damage + ". Current health: " + currentEnemy.getHealth());
            if (currentEnemy.getHealth() <= 0) {
                removeEnemy();
            }
        }
    
        if (currentEnemy2 != null) {
            currentEnemy2.setHealth(currentEnemy2.getHealth() - damage);
            System.out.println("Enemy2 health reduced by " + damage + ". Current health: " + currentEnemy2.getHealth());
            if (currentEnemy2.getHealth() <= 0) {
                removeEnemy();
            }
        }
    }
    public void activateDPSBoost() {
    dpsBoostActive = true;
    cooldownTime = 0;    
    new Timer().schedule(new TimerTask() {
        @Override
        public void run() {
            dpsBoostActive = false;
            cooldownTime = 500; 
        }
    }, 10000);
}
private void drawInventoryScreen(Graphics g2d) {
    g2d.setColor(Color.BLACK);
    g2d.fillRect(0, 0, getWidth(), getHeight());
    g2d.setColor(Color.WHITE);
    g2d.setFont(new Font("Arial", Font.BOLD, 30));
    g2d.drawString("Inventory", 50, 50);

    int yOffset = 100;
    for (Item item : player.getInventory().getItems()) {
        g2d.drawString(item.getName(), 50, yOffset);
        yOffset += 50;
    }
}
}
        //update