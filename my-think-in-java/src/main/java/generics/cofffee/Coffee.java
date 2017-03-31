package generics.cofffee;

/**
 * Created by qinbingbing on 2/2/16.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
