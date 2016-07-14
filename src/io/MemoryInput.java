package io;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class MemoryInput {
    public static void main(String[] args) {
        StringReader reader = new StringReader(BufferedInputFile.read("/Users/didi/IdeaProjects/MyThinkInJava/src/io/MemoryInput.java"));
        int c;
        try {
            while ((c = reader.read()) != -1)
                System.out.print((char)c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
