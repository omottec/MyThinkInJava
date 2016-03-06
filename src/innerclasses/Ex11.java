package innerclasses;

/**
 * Created by qinbingbing on 1/28/16.
 */
interface Ex11Interface {
    void say(String s);
}

class Test {
    private class Inner implements Ex11Interface {

        @Override
        public void say(String s) {
            System.out.println(s);
        }
    }

    Ex11Interface f() {
        return new Inner();
    }
}

public class Ex11 {
    public static void main(String[] args) {
        Test t = new Test();
        t.f().say("hi");
//        ((Test.Inner) t.f()).say("hello");
    }
}
