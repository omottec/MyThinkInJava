package generics;

import generics.watercolors.Watercolors;

import java.util.EmptyStackException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static generics.watercolors.Watercolors.*;
import static net.mindview.util.Print.print;
import static net.mindview.util.Sets.*;

/**
 * Created by qinbingbing on 2/5/16.
 */
public class Sets17 {
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result;
        if (a instanceof EnumSet)
            result = ((EnumSet)a).clone();
        else
            result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result;
        if (a instanceof EnumSet)
            result = ((EnumSet) a).clone();
        else
            result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        Set<T> result;
        if (a instanceof EnumSet)
            result = ((EnumSet) a).clone();
        else
            result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }

    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        print("set1: " + set1);
        print("set2: " + set2);
        print("union(set1, set2): " + union(set1, set2));
        Set<Watercolors> subset = intersection(set1, set2);
        print("intersection(set1, set2): " + subset);
        print("difference(set1, subset): " + difference(set1, subset));
        print("difference(set2, subset): " + difference(set2, subset));
        print("complement(set1, set2): " + complement(set1, set2));
    }
}
