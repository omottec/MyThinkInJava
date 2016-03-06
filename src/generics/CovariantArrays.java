package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 2/10/16.
 */
class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}

public class CovariantArrays {
    public static void main(String[] args) {
//        List<Fruit> list = new ArrayList<Apple>();
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        try {
            fruit[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
//            e.printStackTrace();
        }
        try {
            fruit[0] = new Orange();
        } catch (Exception e) {
//            System.out.println(e);
            e.printStackTrace();
        }
    }
}
