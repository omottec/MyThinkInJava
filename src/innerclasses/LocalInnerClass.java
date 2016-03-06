package innerclasses;
import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 1/29/16.
 */

interface Counter {
    int next();
}

public class LocalInnerClass {
    private int count = 0;

    Counter getCounter(String name) {
        class LocalCounter implements Counter {

            public LocalCounter() {
                print("LocalCounter");
            }

            @Override
            public int next() {
                printnb(name);
                return count++;
            }
        }
        return new LocalCounter();
    }

    Counter getCounter2(String name) {
        return new Counter() {
            {
                print("Counter");
            }
            @Override
            public int next() {
                printnb(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter
                c1 = lic.getCounter("Local inner "),
                c2 = lic.getCounter2("Anonymous inner ");
        for (int i = 0; i < 5; i++)
            print(c1.next());
        for (int i = 0; i < 5; i++)
            print(c2.next());
    }
}
