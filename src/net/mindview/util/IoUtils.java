package net.mindview.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class IoUtils {
    public static void close(Closeable... list) {
        if (list != null) {
            for (Closeable closeable : list) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
