package pl.grzegorz2047.pobproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by s416045 on 2016-06-13.
 */
public class Game extends Thread {


    private HashMap<String, ArrayList<GameEntity>> hash = new HashMap<String, ArrayList<GameEntity>>();
    private static Random random = new Random();
    private int turn = 1;

    @Override
    public void run() {
            /*
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("mobs.yml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Yaml yaml = new Yaml();
        @SuppressWarnings("unchecked")
        HashMap<String, ArrayList> config = (HashMap<String, ArrayList>) yaml.load(br);

        @SuppressWarnings("unchecked")
        ArrayList<String> mobsStrings = (ArrayList<String>) config.get("mobs");

        Thread thread = new Thread(new Task());
        thread.start();*/

        // while (scanner.)
        Player player = new Player("Grzegorz", 15, 2);
        System.out.println("Hp gracza przed to " + player.getHealth());

        player.changeHealth(-3);
        System.out.println("Hp gracza po to " + player.getHealth());
        Animal sheep = new Animal("Sheep", 10, 2);
        hash.put("Animals", new ArrayList<GameEntity>());
        hash.get("Animals").add(new GameEntity(sheep, sheep));//zeby nie traktowalo jako mob, tylko jako dana instancja klasy.. chyba
        GameEntity entity = hash.get("Animals").get(0);
        entity.getInteractive().interaction(player);
        boolean toDestroy = entity.getDestroyable().toDestroy();
        if (toDestroy) {
            hash.get("Animals").remove(entity);
        }
    }

    public long time_diff_milli(long start, long finish) {
        return (finish - start) * 1000;
    }

    public static Random getRandom() {
        return random;
    }

}
