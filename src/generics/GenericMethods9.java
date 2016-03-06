package generics;

/**
 * Created by qinbingbing on 2/5/16.
 */
public class GenericMethods9 {
    public <T, U, V> void f(T t, U u, V v) {
        System.out.println(t.getClass().getName()
                + " " + u.getClass().getName()
                + " " + v.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods9 gm = new GenericMethods9();
        gm.f("", 1, 1.0);
        gm.f(1.0f, 'c', gm);
    }
}
