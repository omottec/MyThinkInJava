package io.xfiles;

import net.mindview.util.IoUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by qinbingbing on 7/28/16.
 */
public class ThawAlien {
    public static void main(String[] args) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("/Users/didi/IdeaProjects/MyThinkInJava/X.file"));
            Object mystery = in.readObject();
            System.out.println(mystery.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(in);
        }
    }
}
