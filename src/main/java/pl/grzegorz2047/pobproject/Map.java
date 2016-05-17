package pl.grzegorz2047.pobproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s416045 on 2016-05-17.
 */
public class Map {
    private String mapname;
    private int length;
    private int width;
    private List<Mob> mobs = new ArrayList<Mob>();
    private List<Block> blocks = new ArrayList<Block>();

    public String getMapname() {
        return mapname;
    }

    public void setMapname(String mapname) {
        this.mapname = mapname;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public List<Mob> getMobs() {
        return mobs;
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}
