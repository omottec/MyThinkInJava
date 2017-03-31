package generics;

/**
 * Created by qinbingbing on 2/11/16.
 */
public class NotSelfBounded<T> {
    T element;

    NotSelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A5 extends NotSelfBounded<A5> {}

class B5 extends NotSelfBounded<B5> {}

class C5 extends NotSelfBounded<C5> {
    C5 setAndGet(C5 arg) {
        set(arg);
        return get();
    }
}

class D5 {}

class E5 extends NotSelfBounded<D5> {}
