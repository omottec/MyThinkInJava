package operators;
import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 3/30/16.
 */
public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f;
        print("i1: " + Integer.toBinaryString(i1));
        int i2 = 0X2F;
        print("i2: " + Integer.toBinaryString(i2));
        int i3 = 0177;
        print("i3: " + Integer.toBinaryString(i3));
        print("i3:" + i3);
        char c = 0xffff;
        print("c: " + Integer.toBinaryString(c));
        byte b = 0x7f;
        print("b: " + Integer.toBinaryString(b));
        short s = 0x7fff;
        print("s: " + Integer.toBinaryString(s));
        long n1 = 200L;
        long n2 = 200l;
        long n3 = 200;
        float f1 = 1;
        float f2 = 1F;
        float f3 = 1f;
        float f4 = 1L;
        double d1 = 1d;
        double d2 = 1D;
        double d3 = 1.1;
        double d4 = 1;
    }
}
