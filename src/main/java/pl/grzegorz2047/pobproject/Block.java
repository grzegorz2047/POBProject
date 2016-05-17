package pl.grzegorz2047.pobproject;

/**
 * Created by s416045 on 2016-05-17.
 */
public class Block {
    private Location location;
    private RGB color;

    public Block(Location loc, RGB color) {
        this.color = color;
        this.location = loc.clone();
    }
}
