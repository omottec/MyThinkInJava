package io;

import net.mindview.util.IoUtils;

import java.io.*;

/**
 * Created by qinbingbing on 7/28/16.
 */
public class Blip3 implements Externalizable {
    private int i;
    private String s;

    public Blip3() {
        System.out.println("Blip3 Constructor");
    }

    public Blip3(int i, String s) {
        System.out.println("Blip3(int i, String s)");
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return s + " " + i;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blips.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) {
        System.out.println("Constructing object:");
        Blip3 b3 = new Blip3(47, "A String");
        System.out.println("b3 after constructed:" + b3);
        String fileName = "Blip3.out";
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(fileName));
            System.out.println("Saving object:");
            out.writeObject(b3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(out);
        }

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(fileName));
            System.out.println("Recovering object:");
            b3 = (Blip3) in.readObject();
            System.out.println("b3 after recovered:" + b3);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(in);
        }
    }
}
