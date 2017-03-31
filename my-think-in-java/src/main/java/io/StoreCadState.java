package io;

import net.mindview.util.IoUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by qinbingbing on 7/28/16.
 */
abstract class Shape implements Serializable {
    public static final int RED = 1, GREEN = 2, BLUE = 3;
    private int xPos, yPos, dimension;
    private static Random rand = new Random();
    private static int counter = 0;
    public abstract void setColor(int newColor);
    public abstract int getColor();

    public Shape(int xPos, int yPos, int dimension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return getClass()
                + " color[" + getColor()
                + "] xPos[" + xPos
                + "] yPos[" + yPos
                + "] dim[" + dimension
                + "]\n";
    }

    public static Shape randomFactory() {
        int x = rand.nextInt(100);
        int y = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circle(x, y, dim);
            case 1:
                return new Square(x, y, dim);
            case 2:
                return new Line(x, y, dim);
        }
    }
}

class Circle extends Shape {
    private static int color = RED;
    public Circle(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Square extends Shape {
    private static int color;

    public Square(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
        color = RED;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Line extends Shape {
    private static int color = RED;

    public Line(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }

    public static void serializeStaticState(ObjectOutputStream oos) throws IOException {
        oos.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream ois) throws IOException {
        color = ois.readInt();
    }
}

public class StoreCadState {
    public static void main(String[] args) {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();
        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            shapes.add(Shape.randomFactory());
        for (int i = 0; i < 10; i++)
            shapes.get(i).setColor(Shape.GREEN);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("CadState.out"));
            oos.writeObject(shapeTypes);
            Line.serializeStaticState(oos);
            oos.writeObject(shapes);
            System.out.println(shapes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(oos);
        }
    }
}
