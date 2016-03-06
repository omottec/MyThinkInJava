package generics;
import net.mindview.util.Generator;

import static net.mindview.util.Print.*;
/**
 * Created by qinbingbing on 2/11/16.
 */

class FArray {
    public static <T> T[] fill(T[] a, Generator<T> gen) {
        for (int i = 0; i < a.length; i++)
            a[i] = gen.next();
        return a;
    }
}

public class PrimitiveGenericTest {
    public static void main(String[] args) {
        String[] strings = FArray.fill(new String[7], null);
    }
}
