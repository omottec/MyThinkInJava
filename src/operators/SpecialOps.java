package operators;

/**
 * Created by qinbingbing on 7/7/16.
 */
public class SpecialOps {
    private static void boolBitwise(boolean x, boolean y) {
        System.out.println("-----------------------------");
        System.out.println("x:" + x + ", y:" + y);
        System.out.println("x & y:" + (x & y));
        System.out.println("x | y:" + (x | y));
        System.out.println("x ^ y:" + (x ^ y));
    }

    private static void doubleModular(double x, double y) {
        System.out.println("*************************");
        System.out.println("x:" + x + ", y:" + y);
        System.out.println("x % y:" + (x % y));
    }

    public static void main(String[] args) {
        boolean x = false, y = false;
        boolBitwise(x, y);
        x = false;
        y = true;
        boolBitwise(x, y);
        x = true;
        y = false;
        boolBitwise(x, y);
        x = true;
        y = true;
        boolBitwise(x, y);

        double d = 1.1, d1 = 1.2;
        doubleModular(d1, d);
        d1 = 0.9;
        doubleModular(d1, d);
    }
}
