package generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by qinbingbing on 2/11/16.
 */
@SuppressWarnings("unchecked")
public class ClassCasting {
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
//        List<Integer> li1 = List<Integer>.class.cast(in.readObject());
        List<Integer> li2 = List.class.cast(in.readObject());
        List<Integer> li3 = (List<Integer>)List.class.cast(in.readObject());
    }
}
