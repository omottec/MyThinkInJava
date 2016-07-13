package io;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by qinbingbing on 7/13/16.
 */
public class DirList3Ex3 {
    public static void main(String[] args) {
        File file = new File(".");
        String[] list;
        if (args.length == 0)
            list = file.list();
        else
            list = file.list(new FilenameFilter() {
                Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    System.out.println("accept dir:" + dir + ", name:" + name);
                    return pattern.matcher(name).matches();
                }
            });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        long lengthSum = 0;
        File file1;
        for (String dirItem : list) {
            file1 = new File(dirItem);
            lengthSum += file1.length();
            System.out.println(dirItem + " length:" + file1.length());
        }
        System.out.println("lengthSum:" + lengthSum);
    }
}
