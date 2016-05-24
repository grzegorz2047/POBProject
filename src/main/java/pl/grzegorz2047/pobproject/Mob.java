package pl.grzegorz2047.pobproject;

/**
 * Created by s416045 on 2016-05-17.
 */
public class Mob implements Movable {

    private Location location;
    private int health;

    public Mob(Location loc, int health) {
        this.location = loc;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean move() {
        int dir = Main.getRandom().nextInt(3);
        if (dir == 0) {
            String newLoc = location.getX() + ":" + location.getY();

        }
        return false;
    }
}
