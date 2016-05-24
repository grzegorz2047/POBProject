package pl.grzegorz2047.pobproject;

/**
 * Created by s416045 on 2016-05-17.
 */
public class Block {
    private Location location;
    private RGB color;
    private Material blockType;

    public Block(Location loc, Material blockType, RGB color) {
        this.color = color;
        this.location = loc.clone();
        this.blockType = blockType;
    }

    @Override
    public String toString() {
        return location.toString() + color.toString() + blockType.name();
    }
}
