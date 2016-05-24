package pl.grzegorz2047.pobproject;

/**
 * Created by s416045 on 2016-05-24.
 */
public class Task implements Runnable {

    public void run() {
        for (Mob mob : Main.getMap().getMobs()) {
            mob.move();
        }
    }
}
