package pl.grzegorz2047.pobproject;

import pl.grzegorz2047.pobproject.mobs.Animal;
import pl.grzegorz2047.pobproject.mobs.Player;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by s416045 on 2016-06-13.
 */
public class Game extends Thread {

    private ArrayList<Player> players = new ArrayList<Player>();
    private HashMap<String, ArrayList<GameEntity>> hash = new HashMap<String, ArrayList<GameEntity>>();
    private int turn = 1;
    private Event event = new Event();

    @Override
    public void run() {
        boolean keepLoop = true;
        while (keepLoop) {
            for (Player player : this.players) {
                String eventType = event.callEvent();
                if (eventType.equals("Idle")) {
                    System.out.println("Gracz " + player.getName() + " odpoczywa");
                    continue;
                }
                int randomNumber = hash.get(eventType).size();
                if (randomNumber <= 0) {
                    System.out.println("Gracz " + player.getName() + " idzie przez pustkowia");
                    continue;
                }
                randomNumber = Main.getRandom().nextInt(hash.get(eventType).size());
                GameEntity entity = hash.get(eventType).get(randomNumber);
                entity.getInteractive().interaction(player);

                boolean toDestroy = entity.getDestroyable().toDestroy();
                if (toDestroy) {
                    hash.get(eventType).remove(entity);
                    //                hash.get(eventType).delete_at(randomNumber);
                }
            }
            for (int i = 0; i < this.players.size(); i++) {
                Player p = players.get(i);
                boolean destroy = p.toDestroy();
                if (destroy) {
                    this.players.remove(p);
                }
            }
            if (this.players.size() == 0) {
                System.out.println("Symulator zakonczyl swoja prace! Wszyscy gracze zgineli! Rozgrywka trwala " + turn + " tur/y");
                keepLoop = false;
            } else if (hash.get("Monsters").size() == 0) {
                System.out.println("Symulator zakonczyl swoja prace! Gracz/e zabil/i wszystkie potwory! Rozgrywka trwala " + turn + " tur/y");
                keepLoop = false;
            }
            if (turn % 10 == 0) {
                long t1 = System.currentTimeMillis();
                System.out.println("Zapisuje stan programu!");
                //FileManagement.saveGame(hash, turn)
                long t2 = System.currentTimeMillis();
                long msecs = timeDiffMillis(t1, t2);
                System.out.println("Zapisano stan gry w " + msecs + " milisekund");
            }
            turn += 1;
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                keepLoop = false;
                e.printStackTrace();
            }
        }
    }

    public long timeDiffMillis(long start, long finish) {
        return (finish - start) * 1000;
    }

    public void load() {
        for (String eventType : event.getEventTypes()) {
            hash.put(eventType, new ArrayList<GameEntity>());
        }
        List<String> data = FileManagement.loadFileToList("data.dat");
        for (String line : data) {
            String[] splitted = line.split(",");// HashMap key, ClassName, args...
            try {
                GameEntity entity = Parser.parse(splitted);
                //System.out.print("Dodaje do hash key "+splitted[0]);
                hash.get(splitted[0]).add(entity);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | ClassNotFoundException e) {
                //System.out.print("Linia " + line + " nie zostala wczytana  z powodu " + e.getMessage());
                e.printStackTrace();
            }
        }
        List<String> playerData = FileManagement.loadFileToList("PlayerData.dat");
        for (String line : data) {
            String[] splitted = line.split(",");// HashMap key, ClassName, args...
            players.add(new Player(splitted));
        }

        //hash.get("Animals").add(new GameEntity(sheep, sheep));//zeby nie traktowalo jako mob, tylko jako dana instancja klasy.. chyba
    }

}
