package pl.grzegorz2047.pobproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by s416045 on 2016-05-24.
 */
public class BlocksManager {



    public static Block parseBlocks(String block) {
        String[] args = block.split(":");
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        Material material = Material.valueOf(args[2]);
        int r = Integer.parseInt(args[3]);
        int g = Integer.parseInt(args[4]);
        int b = Integer.parseInt(args[5]);
        return new Block(new Location(x, y), material, new RGB(r, g, b));
    }




}
