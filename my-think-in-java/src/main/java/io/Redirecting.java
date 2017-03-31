package io;

import net.mindview.util.IoUtils;

import java.io.*;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class Redirecting {
    public static void main(String[] args) {
        PrintStream console = System.out;
        BufferedInputStream in = null;
        PrintStream out = null;
        String path = "/Users/didi/IdeaProjects/MyThinkInJava/src/io/Redirecting.java";
        try {
            in = new BufferedInputStream(new FileInputStream(path));
            out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.path")));
            System.setIn(in);
            System.setOut(out);
            System.setErr(out);
            String s;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while ((s = br.readLine()) != null)
                System.out.println(s);
            System.setOut(console);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(in, out);
        }
    }
}
