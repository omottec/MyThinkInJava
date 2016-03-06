package generics;

/**
 * Created by qinbingbing on 2/11/16.
 */

class Other {}

class BasicOther extends BasicHolder<Other> {}

public class Unconstrained {
    public static void main(String[] args) {
        BasicOther
                b = new BasicOther(),
                b2 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f();
    }
}
