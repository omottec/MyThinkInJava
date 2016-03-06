package generics;

/**
 * Created by qinbingbing on 2/5/16.
 */
public class GenericMethods10 {
    public <T, U, Integer> void f(T t, U u, Integer i) {
        System.out.println(t.getClass().getName()
                + " " + u.getClass().getName()
                + " " + i.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods10 gm = new GenericMethods10();
        gm.f("", 1, 1);
        gm.f(1.0f, 'c', 1);
    }
}
