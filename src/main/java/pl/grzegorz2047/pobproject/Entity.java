package pl.grzegorz2047.pobproject;

/**
 * Created by s416045 on 2016-05-17.
 */
public class Entity {

    private Location location;
    private RGB color;

    public Entity(Location loc, RGB color) {
        this.color = color;
        this.location = loc.clone();
    }


}
