package innerclasses;

/**
 * Created by qinbingbing on 1/29/16.
 */

interface U {
    void f();

    void g();

    @Override
    String toString();
}

class M {
    U buildU() {
        return new U() {
            @Override
            public void f() {
                System.out.println("f()");
            }

            @Override
            public void g() {
                System.out.println("g()");
            }

            @Override
            public String toString() {
                return "I'm a U";
            }
        };
    }
}

class N {
    private U[] us;

    N(int i) {
        us = new U[i];
    }

    void addU(U u, int i) {
        us[i] = u;
    }

    void eraseU(int i) {
        us[i] = null;
    }

    void testUs() {
        for (U u : us) {
            u.f();
            u.g();
            u.toString();
        }
    }

    void showUs() {
        for (U u : us) {
            if (u != null)
                System.out.println(u.toString());
            else
                System.out.println("I'm null");
        }
    }
}

public class Ex23 {
    public static void main(String[] args) {
        M m0 = new M();
        M m1 = new M();
        M m2 = new M();
        N n = new N(3);
        n.addU(m0.buildU(), 0);
        n.addU(m1.buildU(), 1);
        n.addU(m2.buildU(), 2);
        n.showUs();
        n.testUs();
        n.eraseU(0);
        n.eraseU(1);
        n.showUs();
    }
}
