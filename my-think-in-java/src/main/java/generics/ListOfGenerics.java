package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 2/9/16.
 */
public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<>();
    public void add(T item) {
        array.add(item);
    }
    public T get(int index) {
        return array.get(index);
    }
}
