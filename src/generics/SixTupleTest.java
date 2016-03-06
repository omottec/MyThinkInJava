package generics;

import net.mindview.util.FiveTuple;
import net.mindview.util.SixTuple;

/**
 * Created by qinbingbing on 2/2/16.
 */

public class SixTupleTest {
    static SixTuple<Robot,Vehicle,Amphibian,String,Integer,Double> f() {
        return new SixTuple<>(new Robot("robot"), new Vehicle(), new Amphibian(),
                "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        SixTuple<Robot, Vehicle, Amphibian, String, Integer, Double> st = f();
        System.out.println(st);
        System.out.println(f());
    }
}
