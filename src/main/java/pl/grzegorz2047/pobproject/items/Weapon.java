package pl.grzegorz2047.pobproject.items;

import pl.grzegorz2047.pobproject.mobs.Player;

import java.io.Serializable;

/**
 * Created by s416045 on 2016-06-13.
 */
public class Weapon extends Item implements Serializable {
    private int attackPoints;

    public Weapon(String name, int attackPoints) {
        super(name);
        this.attackPoints = attackPoints;
    }
    public Weapon(String[] args) {
        super(args[2]);
        this.attackPoints = Integer.parseInt(args[3]);
    }
    public int getAttackPoints() {
        return this.attackPoints;
    }

    public void interaction(Player p) {
        if (p.getAttackPoints() < this.attackPoints) {
            p.setAttackPoints(this.attackPoints);
            System.out.println("Gracz " + p.getName() + " podniosl " + this.name + " i go zabral");
            this.destroyed = true;
        } else {
            System.out.println("Gracz " + p.getName() + " znalazl " + this.name + " i go zostawil");
        }
    }


}
