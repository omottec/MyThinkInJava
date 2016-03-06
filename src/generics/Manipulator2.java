package generics;

/**
 * Created by qinbingbing on 2/7/16.
 */
class Manipulator2<T extends HasF> {
    private T obj;
    public Manipulator2(T x) {
        obj = x;
    }
    public void manipulate() {
        obj.f();
    }
}
