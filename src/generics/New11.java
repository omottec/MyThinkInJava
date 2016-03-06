package generics;

import net.mindview.util.New;

import java.util.*;

/**
 * Created by qinbingbing on 2/5/16.
 */

class A {
    @Override
    public String toString() {
        return "A";
    }
}

class B {
    @Override
    public String toString() {
        return "B";
    }
}

class C extends B {
    @Override
    public String toString() {
        return "C";
    }
}

public class New11 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        List<C> lc = New.list();
        lc.add(new C());
        Map<A, List<? extends B>> mab = New.map();
        mab.put(a, lc);
        LinkedList<B> llb = New.lList();
        llb.add(new B());
        Set<A> sa = New.set();
        sa.add(new A());
        Queue<B> qb = New.queue();
        qb.add(new B());
        System.out.println(lc);
        System.out.println(mab);
        System.out.println(llb);
        System.out.println(sa);
        System.out.println(qb);
    }
}
