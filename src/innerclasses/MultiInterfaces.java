package innerclasses;

/**
 * Created by qinbingbing on 1/29/16.
 */

interface A {}

interface B {}

class X implements A, B {}

class Y implements A {
    B makeB() {
        return new B() {};
    }
}

public class MultiInterfaces {
    static void takesA(A a) {}
    static void takesB(B b) {}

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesB(x);
        takesA(y);
        takesB(y.makeB());
    }
}
