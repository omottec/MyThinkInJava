package operators;
import java.util.Random;

import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 3/30/16.
 */
public class MathOps {
    public static void main(String[] args) {
        Random random = new Random(47);
        int i, j, k;
        j = random.nextInt(100) + 1;
        print("j: " + j);
        k = random.nextInt(100) + 1;
        print("k: " + k);
        i = j + k;
        print("j + k : " + i);
        i = j - k;
        print("j - k : " + i);
        i = k / j;
        print("k / j : " + i);
        i = k * j;
        print("k * j : " + i);
        i = k % j;
        print("k % j : " + i);
        j %= k;
        print("j %= k : " + j);

        // Floating-point number tests
        float u, v, w; //Apply to doubles
        v = random.nextFloat();
        print("v : " + v);
        w = random.nextFloat();
        print("w : " + w);
        u = v + w;
        print("v + w : " + u);
        u = v - w;
        print("v - w : " + u);
        u = v * w;
        print("v * w : " + u);
        u = v / w;
        print("v / w : " + u);

        // The following also woks for char, byte, short, int, long, double
        u += v;
        print("u += v : " + u);
        u -= v;
        print("u -= v : " + u);
        u *= v;
        print("u *= v : " + u);
        u /= v;
        print("u /= v : " + u);

        float m = 0.1f, n = 0.0f;
        m /= n;
        print("m /= n : " + m);
    }
}
