package io;

import java.io.File;
import java.io.IOException;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class MakeDirectories {
    private static void usage() {
        System.err.println("Usage:MakeDirectories path1 ...\n"
                + "Creates each path\n"
                + "Usage:MakeDirectories -d path1 ...\n"
                + "Deletes each path\n"
                + "Usage:MakeDirectories -r path1 path2\n"
                + "Renames from path1 to path2"
        );
        System.exit(1);
    }

    private static void fileData(File f) throws IOException {
        System.out.println("getAbsolutePath:" + f.getAbsolutePath()
                + "\ngetName:" + f.getName()
                + "\ngetCanonicalPath:" + f.getCanonicalPath()
                + "\ngetPath:" + f.getPath()
                + "\nexists:" + f.exists()
                + "\ncanRead:" + f.canRead()
                + "\ncanWrite:" + f.canWrite()
                + "\ngetParent:" + f.getParent()
                + "\nlength:" + f.length()
                + "\nlastModified:" + f.lastModified());
        if (f.isFile())
            System.out.println("It's a file");
        else if (f.isDirectory())
            System.out.println("It's a directory");
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 1) usage();
        if (args[0].equals("-r")) {
            if (args.length != 3) usage();
            File
                    old = new File(args[1]),
                    rname = new File(args[2]);
            System.out.println("--------before rename---------");
            fileData(old);
            fileData(rname);
            System.out.println("--------after rename-----------");
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return;
        }
        int index = 0;
        boolean del = false;
        if (args[0].equals("-d")) {
            index++;
            del = true;
        }
        index--;
        while (++index < args.length) {
            File f = new File(args[index]);
            if (f.exists()) {
                System.out.println(f + " exists");
                if (del) {
                    System.out.println("deleting..." + f);
                    f.delete();
                }
            } else {
                if (!del) {
                    f.mkdirs();
                    System.out.println("created " + f);
                }
            }
            fileData(f);
        }
    }
}
