package pl.grzegorz2047.pobproject;

import java.io.*;
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

    */

    public static void saveObject(Object object, String saveName) {
        try {
            FileOutputStream fos = new FileOutputStream(saveName);
            ObjectOutputStream oos = new ObjectOutputStream(fos); //to byte
            oos.writeObject(object);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static Object loadObject(String saveName) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(saveName);
            ois = new ObjectInputStream(fis);
            return ois.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void removeSaves() {//do String[] i forem
        File f = new File("savedTurn.sav");
        File f2 = new File("savedHash.sav");
        File f3 = new File("savedPlayers.sav");
        f.delete();
        f2.delete();
        f3.delete();
    }

}
