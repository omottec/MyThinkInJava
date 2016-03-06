package generics;

/**
 * Created by qinbingbing on 2/7/16.
 */
class Manipulator3 {
    private HasF obj;
    public Manipulator3(HasF x) {
        obj = x;
    }
    public void manipulate() {
        obj.f();
    }
}
