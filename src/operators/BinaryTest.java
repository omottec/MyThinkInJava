package operators;
import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 3/30/16.
 */
public class BinaryTest {
    public static void main(String[] args) {
        int i = 1 + 4 + 16 + 64;
        int j = 2 + 8 + 32 + 128;
        print("i = " + Integer.toBinaryString(i));
        print("j = " + Integer.toBinaryString(j));
        print("i & j = " + Integer.toBinaryString(i & j));
        print("i | j = " + Integer.toBinaryString(i | j));
        print("i ^ j = " + Integer.toBinaryString(i ^ j));
        print("~i = " + Integer.toBinaryString(~i));
        print("~j = " + Integer.toBinaryString(~j));
    }
}
