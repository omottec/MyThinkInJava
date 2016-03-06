package generics;

/**
 * Created by qinbingbing on 2/2/16.
 */

class Robot {
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class HolderEx2<T> {
    private T x, y, z;

    public HolderEx2(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getZ() {
        return z;
    }

    public void setZ(T z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return x + ", " + y + ", " + z;
    }

    public static void main(String[] args) {
        Robot a = new Robot("bot1");
        Robot b = new Robot("bot2");
        Robot c = new Robot("bot3");
        HolderEx2<Robot> hEx2 = new HolderEx2<>(a, b, c);
        System.out.println("Holding: " + hEx2);
    }
}
