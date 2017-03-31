package io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by qinbingbing on 7/27/16.
 */
public class LargeMappedFiles {
    static int length = 0x8ffffff;

    public static void main(String[] args) {
        try {
            MappedByteBuffer out = new RandomAccessFile("test.dat", "rw")
                    .getChannel()
                    .map(FileChannel.MapMode.READ_WRITE, 0, length);
            for (int i = 0; i < length; i++)
                out.put((byte) 'x');
            System.out.println("Finished writing");
            for (int i = length / 2; i < length / 2 + 6; i++) {
                byte b = out.get(i);
                System.out.print("byte:" + b + ", char:" + (char)b);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
