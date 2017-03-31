package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 2/7/16.
 */
public class ListMaker<T> {
    List<T> create() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<>();
//        List<String> stringList = stringMaker.create();
        List<String> stringList = new ArrayList();
    }
}
