import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
public class Main extends JFrame{
private static final int WIDTH =1800;
private static final int HEIGHT=1600;
public Main () {
super("KeyListener Demo");
setSize(WIDTH, HEIGHT);
Game play = new Game();
((Component) play).setFocusable(true);
Color RoyalBlue = new Color(22,13,193);
setBackground(Color.BLACK);
getContentPane().add(play);
setVisible(true);
addWindowListener(new WindowListener() {

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
        play.createFile();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }
});


setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}public static void main(String[] args) {
Main run = new Main();
}





}
