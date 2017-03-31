package net.mindview.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by qinbingbing on 7/13/16.
 */
public final class Directory {
    public static File[] local(File dir, String regex) {
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(name);
//                System.out.println("---------");
//                System.out.println(file.getName());
//                System.out.println(file.getPath());
//                System.out.println(file.getAbsolutePath());
                return file.getName().matches(regex);
            }
        });
    }

    public static File[] local(String path, String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs)
                    + "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else
                if (item.getName().matches(regex))
                    result.files.add(item);
        }
//        System.out.println("-------------------------");
//        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        if (args.length == 0)
            System.out.println(walk(""));
        else
            for (String arg : args)
                System.out.println(walk(arg));
    }
}
