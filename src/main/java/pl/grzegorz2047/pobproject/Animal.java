package pl.grzegorz2047.pobproject;

/**
 * Created by s416045 on 2016-06-13.
 */
public class Animal extends Mob {
    private int healthIncreaseValue;

    public Animal(String name, int health, int healthIncreaseValue) {
        super(name, health);
        this.healthIncreaseValue = healthIncreaseValue;
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
            System.out.println(player.getName() + " zabil " + this.name + " i ma teraz  " + player.getHealth() + " punktow zdrowia");
        }else{
            System.out.println(player.getName() + " znalazl " + this.name + " ale jest najedzony i ja zostawia");
        }
    }
}
