package io;

import java.io.PrintWriter;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println("Hello World");
    }
}
