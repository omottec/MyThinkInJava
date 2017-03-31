package generics;

/**
 * Created by qinbingbing on 2/9/16.
 */
interface Factory1<T> {
    T create(Integer i);
}

class Foo1<T> {
    private T x;
    public void get() {
        System.out.println(x);
    }
    public <F extends Factory1<T>> Foo1(F factory, Integer i) {
        x = factory.create(i);
    }
}

class IntegerFactory1 implements Factory1<Integer> {

    @Override
    public Integer create(Integer i) {
        return i;
    }
}

class Widget1 {
    int i;
    public static class Factory1 implements generics.Factory1<Widget1> {

        @Override
        public Widget1 create(Integer i) {
            Widget1 w1 = new Widget1();
            w1.i = i;
            return w1;
        }
    }

    @Override
    public String toString() {
        return "Widget " + i;
    }
}

public class FactoryConstraint23 {
    public static void main(String[] args) {
        Foo1 f1 = new Foo1(new IntegerFactory1(), 1);
        Foo1 f2 = new Foo1(new Widget1.Factory1(), 2);
        f1.get();
        f2.get();
    }
}
