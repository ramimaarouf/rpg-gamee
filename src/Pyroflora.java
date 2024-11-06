import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Pyroflora extends Planets implements KeyListener {
    private BufferedImage back;
    private String screen = "Planet2"; 
    private Characters player;
    private ArrayList<Characters> charList;
    private ArrayList<Enemy> enemies;
    private boolean alienStatsPrinted = false;

    // Parameterized constructor
    public Pyroflora(String name, String imagePath) {
        super(name, imagePath);
        initializeComponents();
    }

    private void initializeComponents() {
        this.charList = new ArrayList<>();
        this.enemies = new ArrayList<>();
        back = new BufferedImage(1600, 800, BufferedImage.TYPE_INT_RGB);
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