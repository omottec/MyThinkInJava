package generics;

/**
 * Created by qinbingbing on 2/7/16.
 */
public class ReturnGenericType<T extends HasF> {
    private T obj;
    public ReturnGenericType(T x) {
        obj = x;
    }
    public T get() {
        return obj;
    }
}
