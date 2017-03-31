package net.mindview.util;

import java.io.*;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class BinaryFile {
    public static byte[] read(File bFile) {
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(bFile));
            byte[] bytes = new byte[bis.available()];
            bis.read(bytes);
            return bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            IoUtils.close(bis);
        }
    }

    public static byte[] read(String bFile) {
        return read(new File(bFile).getAbsoluteFile());
    }
}
