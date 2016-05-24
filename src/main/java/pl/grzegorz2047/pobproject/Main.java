package pl.grzegorz2047.pobproject;

import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import pl.grzegorz2047.pobproject.Map;

/**
 * Created by s416045 on 2016-05-17.
 */
public class Main {


    private static Random random = new Random();


    private static Map map;

    public static void main(String[] args) {
        map = new Map();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("blocks.yml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Yaml yaml = new Yaml();
        @SuppressWarnings("unchecked")
        HashMap<String, ArrayList> config = (HashMap<String, ArrayList>) yaml.load(br);

        @SuppressWarnings("unchecked")
        ArrayList<String> blocksStrings = (ArrayList<String>) config.get("blocks");
        for (String entry : blocksStrings) {
            Block b = BlocksManager.parseBlocks(entry);
            map.getBlocks().put(b.toString(), b);
        }
        Thread thread = new Thread(new Task());
        thread.start();
        Scanner scanner = new Scanner(System.in);
       // while (scanner.)
    }

    public static Random getRandom() {
        return random;
    }

    public static Map getMap() {
        return map;
    }
}
