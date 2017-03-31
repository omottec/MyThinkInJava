package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by qinbingbing on 2/11/16.
 */
public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyInts) {
        probablyInts.add(new Double(1.1));
    }

    public static void main(String[] args) {
        List<Integer> ints1 = new ArrayList<>();
//        oldStyleMethod(ints1);
        List<Integer> ints2 = Collections.checkedList(new ArrayList<>(), Integer.class);
//        oldStyleMethod(ints2);
        try {
            oldStyleMethod(ints2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Number> numbers = Collections.checkedList(new ArrayList<>(), Number.class);
        numbers.add(1);
        numbers.add(1.1);
    }
}
