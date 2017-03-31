package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 2/10/16.
 */
public class GenericWriting {
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruit = new ArrayList<>();

    static void f1() {
        writeExact(apples, new Apple());
//        writeExact(apples, new Fruit());
        writeExact(fruit, new Apple());
    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
