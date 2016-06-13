package pl.grzegorz2047.pobproject.mobs;

import pl.grzegorz2047.pobproject.interfaces.Attackable;
import pl.grzegorz2047.pobproject.interfaces.Destroyable;
import pl.grzegorz2047.pobproject.interfaces.Interactive;

import java.io.Serializable;

/**
 * Created by s416045 on 2016-06-13.
 */
public abstract class Mob implements Attackable, Interactive, Destroyable, Serializable {
    protected int health;
    protected String name;
    protected boolean destroyed;

    public Mob(String name, int health) {
        this.health = health;
        this.name = name;
        this.destroyed = false;
    }

    public String getName() {
        return this.name;
    }

    public boolean toDestroy() {
        return this.destroyed;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean isKilled() {
        return this.health <= 0;
    }

    public void setToDestroy(boolean value) {
        this.destroyed = value;
    }

    public void interaction(Player player) {
        System.out.print(this.name + " wszedl w interakcje z " + player.getName());
    }

    public void changeHealth(int health) {
        this.health += health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
