package pl.grzegorz2047.pobproject.mobs;

import java.io.Serializable;

/**
 * Created by s416045 on 2016-06-13.
 */
public class AgressiveMob extends Mob implements Serializable {
    protected int attackPoints;
    protected int maxHealth;

    public AgressiveMob(String name, int health, int attackPoints) {
        super(name, health);
        this.attackPoints = attackPoints;
        this.maxHealth = health;
    }

    public AgressiveMob(String[] args) {
        super(args[2], Integer.parseInt(args[3]));
        this.attackPoints = Integer.parseInt(args[4]);
        this.maxHealth = Integer.parseInt(args[3]);
    }

    public int getAttackPoints() {
        return this.attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    @Override
    public void interaction(Player player) {
        int mobAttacks = (this.health / player.getAttackPoints());
        int playerAttacks = (player.getHealth() / this.attackPoints);
        int newHealth = player.getHealth() - (mobAttacks * this.attackPoints);
        if (newHealth <= 0) {
            player.setToDestroy(true);
            System.out.println("Gracz " + player.getName() + " zginal przez " + this.name + " w " + mobAttacks + " atakach");
        } else {
            this.destroyed = true;
            player.changeHealth(-(mobAttacks * this.attackPoints));
            if (mobAttacks == 0) {
                playerAttacks = 1;
            }
            System.out.println("Gracz " + player.getName() + " zabil " + this.name + " w " + playerAttacks + " atak/u/ach");
            System.out.println("Gracz " + player.getName() + " ma teraz " + player.getHealth() + " / " + player.getMaxHealth());
        }
    }

    public void setToDestroy(boolean value) {
        this.destroyed = value;
    }
}
