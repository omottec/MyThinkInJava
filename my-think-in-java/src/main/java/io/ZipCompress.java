package io;

import net.mindview.util.IoUtils;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * Created by qinbingbing on 7/27/16.
 */
public class ZipCompress {
    public static void main(String[] args) {
        String fileName = "test.gz";
        BufferedOutputStream out = null;
        CheckedOutputStream csum = null;
        try {
            FileOutputStream f = new FileOutputStream(fileName);
            csum = new CheckedOutputStream(f, new Adler32());
            ZipOutputStream zos = new ZipOutputStream(csum);
            out = new BufferedOutputStream(zos);
            zos.setComment("A test of Java Zipping");
            for (String arg : args) {
                System.out.println("Writing entry " + arg);
                BufferedReader in = new BufferedReader(new FileReader(arg));
                zos.putNextEntry(new ZipEntry(arg));
                int c;
                while ((c = in.read()) != -1)
                    out.write(c);
                IoUtils.close(in);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(out);
        }

        // Checksum valid only after the file has been closed!
        System.out.println("Checksum: " + csum.getChecksum().getValue());

        // Now extract the files:
        System.out.println("Reading file-----------------");
        BufferedInputStream bis = null;
        CheckedInputStream csumi = null;
        try {
            FileInputStream fi = new FileInputStream(fileName);
            csumi = new CheckedInputStream(fi, new Adler32());
            ZipInputStream in2 = new ZipInputStream(csumi);
            bis = new BufferedInputStream(in2);
            ZipEntry ze;
            while ((ze = in2.getNextEntry()) != null) {
                System.out.println("Reading entry name:" + ze.getName() + ", comment:" + ze.getComment());
                int x;
                while ((x = bis.read()) != -1)
                    System.out.write(x);
            }
            if (args.length == 1)
                System.out.println("Checksum: " + csumi.getChecksum().getValue());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(bis);
        }

        // Alternative way to open and read zip files
        System.out.println("------------------------");
        try {
            ZipFile zf = new ZipFile(fileName);
            Enumeration<? extends ZipEntry> e = zf.entries();
            ZipEntry ze;
            while (e.hasMoreElements()) {
                ze = e.nextElement();
                System.out.println("entry: " + ze);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
