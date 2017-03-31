package net.mindview.util;

/**
 * Created by qinbingbing on 2/2/16.
 */
public class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        this.first = a;
        this.second = b;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
