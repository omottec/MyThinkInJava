package io;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by qinbingbing on 7/13/16.
 */
public class DirList3Ex1 {
    public static void main(String[] args) {
        File file = new File("");
        String[] list;
        if (args.length == 0)
            list = file.list();
        else
            list = file.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    System.out.println("accept dir:" + dir + ", name:" + name);
                    BufferedReader reader = null;
                    try {
                        reader = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
                        String line;
                        StringBuilder sb = new StringBuilder();
                        while ((line = reader.readLine()) != null)
                            sb.append(line).append("\n");
                        if (sb.toString().contains(args[0]))
                            return true;
                        else
                            return false;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        return false;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    } finally {
                        if (reader != null)
                            try {
                                reader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    }
                }
            });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}
