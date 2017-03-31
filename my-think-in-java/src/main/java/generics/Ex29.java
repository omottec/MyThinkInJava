package generics;
import java.util.*;

import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 2/10/16.
 */
public class Ex29 {
    static void f1(Holder<List<?>> holder) {
        print("Calling methods for the Holder: ");
        print("Holder: " + holder);
        print("holder.get(): " + holder.get());
        print("Calling holder.set(Arrays.asList(1, 2, 3))");
        holder.set(Arrays.asList(1, 2, 3));
        print("holder.get(): " + holder.get());
        int[] ia = { 1, 2, 3 };
        print("int[] ia = { 1, 2, 3 }");
        print("holder.equals(ia): " + holder.equals(ia));
        List iaList = Arrays.asList(ia);
        print("List iaList = Arrays.asList(ia)");
        print("holder.equals(iaList): " + holder.equals(iaList));
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i < 4; i++) l.add(i);
        print("l = List<Integer>() and add 1,2,3");
        print("holder.equals(l): " + holder.equals(l));
//        holder.set(l);
        print();

        print("Calling methods for the List: ");
        print("holder.get(): " + holder.get());
        print("holder.get().getClass(): " + holder.get().getClass());
//        List<? extends Integer> list = holder.get();
        List<?> list = holder.get();
        print("list: " + list);
//        list.add(new Object());
        List list1 = holder.get();
//        list1.add(new Object());
//        UnsupportedOperationException
        print("list1.getClass(): " + list1.getClass());
        print("list.equals(list1): " + list.equals(list1));
//        list.clear();
//        Arrays$ArrayList UnsupportedOperationException
        System.out.println("list.contains(1): " + list.contains(1));
        Collection<Integer> c = new HashSet<>();
        for (int i = 1; i < 4; i++) c.add(i);
        print("list.containsAll(c): " + list.containsAll(c));
        print("list.equals(c): " + list.equals(c));
        print("list: " + list);
        print("c: " + c);
        print("c.getClass(): " + c.getClass());
        print("list.get(0): " + list.get(0));
        print("list.hashCode(): " + list.hashCode());
        print("list.indexOf(2): " + list.indexOf(2));
        ListIterator<?> li = list.listIterator();
        print("After ListIterator<?> li = list.listIterator();");
        print("li.next(): " + li.next());
//        list.remove(0);
//        list.removeAll(c);
//        list.retainAll(c);
//        list.set(1, 4);
        print("list.size(): " + list.size());
        print("list.subList(1, 2): " + list.subList(1, 2));
        Object[] oa = list.toArray();
        print("After Object[] oa = list.toArray();");
        print("oa: " + oa);
        for (Object o : oa)
            printnb(o + " ");
        print();
//        Double[] da = list.toArray(new Double[3]);
        Number[] na = list.toArray(new Number[3]);
        print("After Number[] na = list.toArray(new Number[3])");
        print("na: " + na);
        for (Number n : na) printnb(n + " ");
        print();
    }

    static void f2(List<Holder<?>> list) {
        print("Calling methods for the list: ");
        print("list: " + list);
        print("Adding Integer, String, Double");
        list.add(new Holder<>(1));
        list.add(new Holder<>("Two"));
        list.add(new Holder<>(3.0));
        print("list: " + list);
        print("Elements of list:");
        for (Holder h : list)
            print("h.get(): " + h.get());
        print("Adding Float");
        list.add(3, new Holder<>(4.0f));
        print("list: " + list);
        print("Elements of list:");
        for (Holder h : list)
            print("h.get(): " + h.get());
        print("list.clear()");
        list.clear();
        print("list: " + list);
        Collection<Holder<?>> c = new ArrayList<>();
        c.add(new Holder<>("one"));
        c.add(new Holder<>(2.0f));
        c.add(new Holder<>(3.0));
        list.addAll(c);
        print("Adding String, Float, Double");
        print("list: " + list);
        print("Elements of list:");
        for (Holder h : list)
            print("h.get(): " + h.get().getClass().getSimpleName() + " " + h.get());
        list.add(3, new Holder<>("four"));
        print("Elements of list:");
        for (Holder h : list)
            print("h.get(): " + h.get().getClass().getSimpleName() + " " + h.get());
        Object listClone = ((ArrayList) list).clone();
        print("listClone(): " + listClone);
        print("listClone.getClass(): " + listClone.getClass());
        print("replace element with h4, new Holder<Integer>(4)");
        Holder<Integer> h4 = new Holder<>(4);
        list.set(3, h4);
        print("Elements of list:");
        for (Holder h : list)
            print("h.get(): " + h.get().getClass().getSimpleName() + " " + h.get());
        print("list.contains(list.set(3, h4)): " + list.contains(list.set(3, h4)));
        print("list.contains(4): " + list.contains(4));
        print("list.contains(h4): " + list.contains(h4));
        print("Adding null member to list");
        list.add(null);
        print("list.contains(null): " + list.contains(null));
        print("list.get(0).get(): " + list.get(0).get());
        print("list.indexOf(h4): " + list.indexOf(h4));
        print("list.indexOf(null): " + list.indexOf(null));
        print("list.isEmpty(): " + list.isEmpty());
        print("list.lastIndexOf(null): " + list.lastIndexOf(null));
        print("Removing index 0");
        list.remove(0);
        print("Elements of list Holders: ");
        for (Holder h : list) {
            if (h == null)
                print(null);
            else
                print(h.get().getClass().getSimpleName() + " " + h.get());
        }
        print("Removing null");
        print("Elements of list Holders: ");
        for (Holder h : list) {
            if (h == null)
                print(null);
            else
                print(h.get().getClass().getSimpleName() + " " + h.get());
        }
        print("list.size(): " + list.size());
        Object[] oa = list.toArray();
        printnb("list.toArray(): ");
        for (int i = 0; i < oa.length; i++) printnb(oa[i] + " ");
        print();
        Holder[] ha = list.toArray(new Holder[4]);
        printnb("list.toArray(new Holder[4]): ");
        for (int i = 0; i < ha.length; i++) printnb(ha[i] + " ");
        print();
        print("Holder[4] Holders are holding: ");
        for (Holder h : ha) {
            if (h == null)
                print("null");
            else
                print(h.get());
        }
        print();
        print("Calling methods for the Holder");
        print("list: " + list);
        print("Three Holders(one null) in list");
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) == null)
                print("null");
            else
                print(list.get(i).getClass().getSimpleName());
        }
        list.remove(3);
        print("Holders are holding:");
        for (Holder h : list) print(h.get());
        Holder<?> h1 = list.get(0);
        Holder<?> h2 = list.get(1);
        Holder<?> h3 = list.get(2);
        print(list.get(0).getClass()
                + ": " + list.get(0).getClass().getSimpleName()
                + ", " + list.get(0).get());
        print(list.get(1).getClass()
                + ": " + list.get(1).getClass().getSimpleName()
                + ", " + list.get(1).get());
        print(list.get(2).getClass()
                + ": " + list.get(2).getClass().getSimpleName()
                + ", " + list.get(2).get());
//        h3.set(5);
//        h3.set(new Object());
    }

    public static void main(String[] args) {
        print("new Holder<>() holder");
        f1(new Holder<>());
        print();
        print("List<Holder<?>> list = new ArrayList<>();");
        List<Holder<?>> list = new ArrayList<>();
        f2(list);

//        f3();
//        f4();
    }

    private static void f3() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        System.out.println(list.contains(2));
        list.set(1, 3);
        System.out.println(list);
        System.out.println(list.contains(3));
        System.out.println(list.contains(list.set(1, 3)));
    }

    public static void f4() {
        List<Holder<?>> list = new ArrayList<>();
        list.add(new Holder<>(1));
        list.add(new Holder<>(2));
        System.out.println(list);
        Holder<Integer> h3 = new Holder<>(3);
        System.out.println("h3: " + h3);
        list.set(1, h3);
        System.out.println(list);
        System.out.println(list.contains(h3));

    }
}
