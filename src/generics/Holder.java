package generics;

import org.omg.PortableInterceptor.HOLDING;

/**
 * Created by qinbingbing on 2/10/16.
 */
public class Holder<T> {
    private T value;

    public Holder() {}

    public Holder(T val) {
        value = val;
    }
    public void set(T val) {
        value = val;
    }
    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
//        if (obj instanceof Holder)
//            return value.equals(((Holder)obj).get());
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);
//        Holder<Fruit> fruit = apple;
        Holder<? extends Fruit> fruit = apple;
        Fruit p = fruit.get();
        d = (Apple) fruit.get();
        try {
            Orange c = (Orange) fruit.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        fruit.set(new Apple());
//        fruit.set(new Fruit());
        System.out.println(fruit.equals(d));
    }
}
