package io;

import net.mindview.util.IoUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by qinbingbing on 7/28/16.
 */
public class RecoverCadState {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("CadState.out"));
            List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) ois.readObject();
            Line.deserializeStaticState(ois);
            List<Shape> shapes = (List<Shape>) ois.readObject();
            System.out.println(shapes);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(ois);
        }
    }
}
