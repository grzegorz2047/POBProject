package pl.grzegorz2047.pobproject;

/**
 * Created by s416045 on 2016-05-17.
 */
public class Location {

    private int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public Location clone() {
        return new Location(x, y);
    }
}
