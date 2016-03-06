package innerclasses;

/**
 * Created by qinbingbing on 1/29/16.
 */

class MNA {
    private void f() {}
    class A {
        private void g() {}
        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mana = mna.new A();
        MNA.A.B mnaab = mana.new B();
        mnaab.h();
    }
}
