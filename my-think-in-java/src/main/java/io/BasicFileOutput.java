package io;

import java.io.*;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class BasicFileOutput {
    static String file = "BasicFileOutput.out";

    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader(
                    new StringReader(
                            BufferedInputFile.read("/Users/didi/IdeaProjects/MyThinkInJava/src/io/BasicFileOutput.java")));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            int lineCount = 1;
            String s;
            while ((s = br.readLine()) != null)
                pw.println(lineCount++ + ": " + s);
            pw.flush();
            System.out.println(BufferedInputFile.read(file));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (pw != null) {
                pw.close();
            }
        }
    }

}
