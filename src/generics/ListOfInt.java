package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 2/11/16.
 */
public class ListOfInt {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            li.add(i);
        for (int i : li)
            System.out.print(i + " ");
    }
}
