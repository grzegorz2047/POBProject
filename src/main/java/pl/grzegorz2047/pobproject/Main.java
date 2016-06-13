package pl.grzegorz2047.pobproject;

import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by s416045 on 2016-05-17.
 */
public class Main {


    private static Random random = new Random();

    public static void main(String[] args) {

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
        thread.start();

       // while (scanner.)
    }

    public static Random getRandom() {
        return random;
    }



 }
