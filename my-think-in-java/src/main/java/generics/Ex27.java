package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 2/10/16.
 */
public class Ex27 {
    public static void main(String[] args) {
        List<? extends Number> nList = new ArrayList<>();
//        nList.add(new Integer());
        nList.add(null);
        Number x = nList.get(0);
        System.out.println(nList);
    }
}
