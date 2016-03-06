package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 2/10/16.
 */
public class GenericAndCovariance {
    public static void main(String[] args) {
//        List<Fruit> list = new ArrayList<Apple>();
        List<? extends Fruit> list = new ArrayList<Apple>();
//        list.add(new Apple());
//        list.add(new Fruit());
//        list.add(new Object());
        list.add(null);
        Fruit f = list.get(0);
    }
}
