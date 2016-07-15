package io;

import net.mindview.util.IoUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by qinbingbing on 7/15/16.
 */
public class TransferTo {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("arguments: sourceFile destFile");
            System.exit(1);
        }
        FileChannel in = null, out = null;
        try {
            in = new FileInputStream(args[0]).getChannel();
            out = new FileOutputStream(args[1]).getChannel();
            in.transferTo(0, in.size(), out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(in, out);
        }
    }
}
