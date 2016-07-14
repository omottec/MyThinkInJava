package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class TestEof {
    public static void main(String[] args) {
        DataInputStream in = null;
        try {
            in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read("/Users/didi/IdeaProjects/MyThinkInJava/src/io/FormattedMemoryInput.java")
                                    .getBytes()));
            while (in.available() != 0)
                System.out.print((char)in.readByte());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
