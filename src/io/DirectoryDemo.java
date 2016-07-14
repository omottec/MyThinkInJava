package io;

import net.mindview.util.Directory;
import net.mindview.util.PPrint;

import java.io.File;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        System.out.println("-----------------------");
        PPrint.pprint(Directory.walk(".").dirs);
        System.out.println("-----------------------");
        for (File file : Directory.local(".", "T.*"))
            System.out.println(file);
        System.out.println("----------------------");
        for (File file : Directory.walk(".", "T.*\\.java"))
            System.out.println(file);
        System.out.println("-----------------------");
        for (File file : Directory.walk(".", ".*[zZ].*\\.class"))
            System.out.println(file);
    }
}
