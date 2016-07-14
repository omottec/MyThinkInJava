package io;

import net.mindview.util.IoUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class UsingRandomAccessFile {
    static String file = "rtest.dat";
    static void display() {
        RandomAccessFile rf = null;
        try {
            rf = new RandomAccessFile(file, "r");
            for (int i = 0; i < 7; i++)
                System.out.println("Value " + i + ": " + rf.readDouble());
            System.out.println(rf.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(rf);
        }
    }

    public static void main(String[] args) {
        RandomAccessFile rf = null;
        try {
            rf = new RandomAccessFile(file, "rw");
            for (int i = 0; i < 7; i++)
                rf.writeDouble(i * 1.414);
            rf.writeUTF("The end of the file");
            display();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(rf);
        }

        try {
            rf = new RandomAccessFile(file, "rw");
            rf.seek(5 * 8);
            rf.writeDouble(47.0001);
            display();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(rf);
        }
    }
}
