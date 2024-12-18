
import java.util.Timer;
import java.util.TimerTask;

public class AlienArtifact extends Item {
    public AlienArtifact() {
        super("Alien Artifact");
    }

    public void useArtifact(Characters player) {
        System.out.println("Alien Artifact activated! Invincibility for 5 seconds.");
        player.setInvincible(true);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                player.setInvincible(false);
                System.out.println("Invincibility ended.");
            }
        }, 5000); // 5 seconds
    }
}