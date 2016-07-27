package io;

import net.mindview.util.IoUtils;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by qinbingbing on 7/27/16.
 */
public class GzipCompress {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: \nGzipCompress file\n"
                    + "\tUses Gzip compression to compress the file to test.gz");
            System.exit(1);
        }
        BufferedReader in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedReader(new FileReader(args[0]));
            out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
            System.out.println("Writing file");
            int c;
            while ((c = in.read()) != -1)
                out.write(c);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(in, out);
        }

        System.out.println("Reading file");
        try {
            in = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
            String line;
            while ((line = in.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(in);
        }
    }
}
