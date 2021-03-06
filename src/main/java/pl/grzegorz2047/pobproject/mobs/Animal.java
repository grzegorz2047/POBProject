package pl.grzegorz2047.pobproject.mobs;

import java.io.Serializable;

/**
 * Created by s416045 on 2016-06-13.
 */
public class Animal extends Mob implements Serializable{
    private int healthIncreaseValue;

    public Animal(String name, int health, int healthIncreaseValue) {
        super(name, health);
        this.healthIncreaseValue = healthIncreaseValue;
    }
    public Animal(String[] args) {
        super(args[2], Integer.parseInt(args[3]));
        this.healthIncreaseValue = Integer.parseInt(args[4]);
    }

    @Override
    public void interaction(Player player) {
        if (player.getHealth() < player.getMaxHealth()) {
            int diffHealth = player.getMaxHealth() - player.getHealth();
            if (diffHealth < this.healthIncreaseValue) {
                player.setHealth(player.getMaxHealth());
            } else {
                player.changeHealth(this.healthIncreaseValue);
            }
            this.destroyed = true;
            System.out.println(player.getName() + " zabil " + this.name + " i ma teraz " + player.getHealth() + " punktow zdrowia");
        }else{
            System.out.println(player.getName() + " zobaczyl " + this.name + " ale jest najedzony i zostawia ja w spokoju");
        }
    }
}
