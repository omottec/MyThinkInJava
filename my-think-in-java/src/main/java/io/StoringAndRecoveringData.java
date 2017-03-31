package io;

import net.mindview.util.IoUtils;

import java.io.*;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) {
        DataOutputStream out = null;
        DataInputStream in = null;
        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data")));
            out.writeDouble(3.14159);
            out.writeUTF("That was pi");
            out.writeDouble(1.41413);
            out.writeUTF("Square root of 2");
            out.flush();
            in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data")));
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(in, out);
        }
    }


}
