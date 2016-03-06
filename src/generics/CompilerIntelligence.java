package generics;

import java.util.Arrays;
import java.util.List;

/**
 * Created by qinbingbing on 2/10/16.
 */
public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> first = Arrays.asList(new Apple());
        Apple a = (Apple) first.get(0);
        first.contains(new Apple());
        first.indexOf(new Apple());
    }
}
