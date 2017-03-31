package generics;

import java.util.List;

/**
 * Created by qinbingbing on 2/10/16.
 */
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
//        apples.add(new Fruit());
    }
}
