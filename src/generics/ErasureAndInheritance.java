package generics;

/**
 * Created by qinbingbing on 2/7/16.
 */

class GenericBase<T> {
    private T element;
    public void set(T arg) {
        element = arg;
    }
    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {

}

class Derived2 extends GenericBase {}

//class Derived3 extends GenericBase<?> {}

public class ErasureAndInheritance {
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);
    }
}
