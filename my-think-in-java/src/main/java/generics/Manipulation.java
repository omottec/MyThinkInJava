package generics;

/**
 * Created by qinbingbing on 2/7/16.
 */

class Manipulator<T> {
    private T obj;
    public Manipulator(T x) {
        obj = x;
    }
    public void manipulate() {
//        obj.f();
    }
}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}
