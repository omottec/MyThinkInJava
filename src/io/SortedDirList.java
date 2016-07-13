package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Created by qinbingbing on 7/13/16.
 */
public class SortedDirList {
    private File dir;
    public SortedDirList(String path) {
        dir = new File(path);
    }

    public String[] list() {
        return dir.list();
    }

    public String[] list(String regex) {
        return dir.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }

    public File getDir() {
        return dir;
    }

    public static void main(String[] args) {
        SortedDirList sortedDirList = new SortedDirList(".");
        String[] array = sortedDirList.list();
        File dir = sortedDirList.getDir();
        System.out.println(dir.getPath());
        System.out.println(dir.getAbsolutePath());
        System.out.println("------------------------------");
        for (String dirItem : array)
            System.out.println(dirItem);
        System.out.println("--------------------------------");
        array = sortedDirList.list(".*\\.java");
        for (String dirItem : array)
            System.out.println(dirItem);
    }
}
