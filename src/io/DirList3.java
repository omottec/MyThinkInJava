package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by qinbingbing on 7/13/16.
 */
public class DirList3 {
    public static void main(String[] args) {
        File file = new File(".");
        String[] list;
        if (args.length == 0)
            list = file.list();
        else
            list = file.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    System.out.println("accept dir:" + dir + ", name:" + name);
                    return pattern.matcher(name).matches();
                }
            });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}
