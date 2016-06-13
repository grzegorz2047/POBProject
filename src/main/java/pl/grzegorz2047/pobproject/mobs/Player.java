package pl.grzegorz2047.pobproject.mobs;

import java.io.Serializable;

/**
 * Created by s416045 on 2016-06-13.
 */
public class Player extends AgressiveMob implements Serializable {

    public Player(String name, int health, int attackPoints) {
        super(name, health, attackPoints);
    }

    public Player(String[] args) {
        super(args[0], Integer.valueOf(args[1]), Integer.parseInt(args[2]));
    }

    @Override
    public void interaction(Player player) {

    }
}
