package access;

import sun.security.provider.Sun;

/**
 * Created by qinbingbing on 1/28/16.
 */
class Sundae {
    private Sundae() {}

    static Sundae makeASundae() {
        return new Sundae();
    }
}

public class IceCream {
    public static void main(String[] args) {
//        Sundae x = new Sundae();
        Sundae x = Sundae.makeASundae();
    }
}
