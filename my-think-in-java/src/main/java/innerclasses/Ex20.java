package innerclasses;

/**
 * Created by qinbingbing on 1/29/16.
 */
interface In {
    class Nested {
        Nested() {
            System.out.println("Nested()");
        }

        public void hi() {
            System.out.println("hi");
        }
    }
}

public class Ex20 {
    public static void main(String[] args) {
        In.Nested in = new In.Nested();
        in.hi();
    }
}
