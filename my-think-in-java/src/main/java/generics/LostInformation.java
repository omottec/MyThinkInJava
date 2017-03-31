package generics;

import java.util.*;

/**
 * Created by qinbingbing on 2/7/16.
 */
class Frob {}
class Fnorkle {}
class Quark<Q> {}
class Particle<POSITION, MOMENTUM> {}

public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Double> p = new Particle<>();
        System.out.println(Arrays.asList(list.getClass().getTypeParameters()));
        System.out.println(Arrays.asList(map.getClass().getTypeParameters()));
        System.out.println(Arrays.asList(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.asList(p.getClass().getTypeParameters()));
    }
}
