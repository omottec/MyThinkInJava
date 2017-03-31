package io;

import net.mindview.util.IoUtils;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by qinbingbing on 7/28/16.
 */
public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }

    @Override
    public String toString() {
        return "logon info:\n   username:" + username
                + "\n   password:" + password
                + "\n   date:" + date;
    }

    public static void main(String[] args) {
        Logon logon = new Logon("Hulk", "myLittlePony");
        System.out.println("after constructed:\n" + logon);
        String fileName = "logon.out";
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(fileName));
            System.out.println("writing object at:" + new Date());
            out.writeObject(logon);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(out);
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(fileName));
            System.out.println("recovering object at:" + new Date());
            logon = (Logon) in.readObject();
            System.out.println("after recover:" + logon);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(in);
        }
    }
}
