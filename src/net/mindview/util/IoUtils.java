package net.mindview.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class IoUtils {
    public static void close(AutoCloseable... list) {
        if (list != null) {
            for (AutoCloseable closeable : list) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
