package generics;

/**
 * Created by qinbingbing on 2/8/16.
 */
interface Factory<T> {
    T create();
}

class Foo2<T> {
    private T x;
    public <F extends Factory<T>> Foo2(F factory) {
        x = factory.create();
    }
}

class IntegerFactory implements Factory<Integer> {

    @Override
    public Integer create() {
        return 0;
    }
}

class Widget {
    public static class Factory implements generics.Factory<Widget> {

        @Override
        public Widget create() {
            return new Widget();
        }
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}
