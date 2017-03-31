package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class BufferedInputFile {
    public static String read(String filename) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = br.readLine()) != null)
                sb.append(s).append('\n');
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(read("/Users/didi/IdeaProjects/MyThinkInJava/src/io/BufferedInputFile.java"));
    }
}
