package io;

import net.mindview.util.IoUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by qinbingbing on 7/28/16.
 */
public class FreezeAlien {
    public static void main(String[] args) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("X.file"));
            Alien quellek = new Alien();
            out.writeObject(quellek);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(out);
        }
    }
}
