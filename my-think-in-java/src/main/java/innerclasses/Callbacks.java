package innerclasses;
import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 1/29/16.
 */

interface Incrementable {
    void increment();
}

class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        print(i);
    }
}

class MyIncrement {
    public void increment() {
        print("Other operation");
    }

    static void f(MyIncrement mi) {
        mi.increment();
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        print(i);
    }

    private class Closure implements Incrementable {

        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementable getCallbackRef() {
        return new Closure();
    }
}

class Caller {
    private Incrementable callbackRef;

    public Caller(Incrementable callbackRef) {
        this.callbackRef = callbackRef;
    }

    void go() {
        callbackRef.increment();
    }
}

public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackRef());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
