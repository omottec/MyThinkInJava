package io;


import net.mindview.util.IoUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 7/28/16.
 */
class House implements Serializable {}

class Animal implements Serializable {
    private String name;
    private House preferredHouse;

    public Animal(String nm, House h) {
        name = nm;
        preferredHouse = h;
    }

    @Override
    public String toString() {
        return name
                + "[" + super.toString() + "]"
                + preferredHouse + "\n";
    }
}

public class MyWorld {
    public static void main(String[] args) {
        House house = new House();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Bosco the dog", house));
        animals.add(new Animal("Ralph the hamster", house));
        animals.add(new Animal("Molly the cat", house));
        System.out.println("animals: " + animals);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream out = null, out1 = null;
        try {
            out = new ObjectOutputStream(buf);
            out1 = new ObjectOutputStream(buf1);
            out.writeObject(animals);
            out.writeObject(animals);
            out1.writeObject(animals);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(out, out1);
        }

        ObjectInputStream in = null, in1 = null;
        try {
            in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
            in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
            List
                    animals1 = (List) in.readObject(),
                    animals2 = (List) in.readObject(),
                    animals3 = (List) in1.readObject();
            System.out.println("animals1:" + animals1);
            System.out.println("animals2:" + animals2);
            System.out.println("animals3:" + animals3);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(in, in1);
        }
    }
}
