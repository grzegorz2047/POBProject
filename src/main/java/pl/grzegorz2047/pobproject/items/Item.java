package pl.grzegorz2047.pobproject.items;

import pl.grzegorz2047.pobproject.interfaces.Destroyable;
import pl.grzegorz2047.pobproject.interfaces.Interactive;
import pl.grzegorz2047.pobproject.mobs.Player;

import java.io.Serializable;

/**
 * Created by s416045 on 2016-06-13.
 */
public abstract class Item implements Interactive, Destroyable, Serializable {
    protected boolean destroyed = false;
    protected String name;

    public Item(String name) {
        this.name = name;
    }

    public boolean toDestroy() {
        return this.destroyed;
    }

    public void setToDestroy(boolean value) {
        this.destroyed = value;
    }

    public void interaction(Player player) {
        System.out.print(player.getName() + " wszedl w interakcje z " + this.name);
    }
}
