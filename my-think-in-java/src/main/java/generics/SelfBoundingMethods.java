package generics;

/**
 * Created by qinbingbing on 2/11/16.
 */
public class SelfBoundingMethods {
    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A4 a = f(new A4());
    }
}
