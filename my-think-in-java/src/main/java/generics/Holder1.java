package generics;

/**
 * Created by qinbingbing on 2/1/16.
 */

class Automobile {}

public class Holder1 {
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    public Automobile get() {
        return a;
    }
}
