package pl.grzegorz2047.pobproject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by s416045 on 2016-06-13.
 */
public class FileManagement {

    public static List<String> loadFileToList(String file) {
        List<String> lines = new ArrayList<String>();
        try {
            File f = new File(file);
            if (!f.exists()) {
                f.createNewFile();
            }
            lines = Files.readAllLines(f.toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }



/*
    public static loadFile(int hash, String filename, String type) {
        array = Array.new
                File.foreach(filename) {
                    |x|array.push(

                    eval(x)

                    )
                }
        hash.store(type, array)
    }


    public static saveGame(int hash, turn) {
        File.open('save/save.sav', 'w')

        {|f | f.write(Marshal.dump(hash))
        }

        File.open('save/savedTurn.sav', 'w')

        {|f | f.write(Marshal.dump(turn))
        }


    }

    public static int loadTurn(turn) {
        turn = Marshal.load(File.read('save/savedTurn.sav'))
        puts "Wczytano numer tury!"
        turn
                end

        public static void loadHash( int hash)

        hash = Marshal.load(File.read('save/save.sav'))
        puts "Wczytano rozgrywke!"
        hash
    }


    public static void removeSaves() {

        File.delete('save/savedTurn.sav');
        File.delete('save/save.sav');

    }
*/
}
