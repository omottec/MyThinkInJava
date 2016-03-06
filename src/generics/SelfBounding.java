package generics;

/**
 * Created by qinbingbing on 2/11/16.
 */

class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A4 extends SelfBounded<A4> {}

class B4 extends SelfBounded<A4> {}

class C4 extends SelfBounded<C4> {
    C4 setAndGet(C4 arg) {
        set(arg);
        return get();
    }
}

class D4 {}

//class E4 extends SelfBounded<D4> {}

class F4 extends SelfBounded {}

public class SelfBounding {
    public static void main(String[] args) {
        A4 a = new A4();
        a.set(new A4());
        a = a.set(new A4()).get();
        a = a.get();
        C4 c = new C4();
        c = c.setAndGet(new C4());
    }
}
