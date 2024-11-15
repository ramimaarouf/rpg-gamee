public class Projectile extends Ranged {
private int x, y;
private int speed;
private int direction;


public Projectile(int x, int y, int speed, String name) {
	super(x, y, speed, name);
	this.x = x;
	this.y = y;
	this.speed = speed;
}
}

