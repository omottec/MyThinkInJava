package io;

import net.mindview.util.IoUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * Created by qinbingbing on 7/27/16.
 */
public class FileLocking {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileLock fl = null;
        try {
            fos = new FileOutputStream("file.txt");
            fl = fos.getChannel().tryLock();
            if (fl != null) {
                System.out.println("Locked File");
                TimeUnit.MILLISECONDS.sleep(100);
                fl.release();
                System.out.println("Release Lock");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(fl, fos);
        }
    }
}
