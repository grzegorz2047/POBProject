package pl.grzegorz2047.pobproject;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.util.ArrayStack;

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
        Game game = new Game();
        game.load();
        game.start();
    }

    public static Random getRandom() {
        return random;
    }


}
