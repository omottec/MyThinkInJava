package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by qinbingbing on 7/13/16.
 */
public class DirList2 {
    public static void main(String[] args) {
        File file = new File(".");
        String[] list;
        if (args.length == 0)
            list = file.list();
        else
            list = file.list(filter(args[0]));
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }

    private static FilenameFilter filter(String regex) {
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
}
