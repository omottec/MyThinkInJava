package generics;

import net.mindview.util.New;

import java.util.List;
import java.util.Map;

/**
 * Created by qinbingbing on 2/5/16.
 */
public class LimitOfInference {
    static void f(Map<String, List<String>> map) {
        System.out.println(map);
    }

    public static void main(String[] args) {
        f(New.map());
        f(New.<String, List<String>>map());
    }
}
