package generics;

import java.util.HashMap;
import java.util.Map;
import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 2/7/16.
 */
class Building1 {}

class House1 extends Building1 {}

public class ClassTypeCapture21<T> {
    Class<?> kind;
    Map<String, Class<?>> map;
    public ClassTypeCapture21(Class<?> kind) {
        this.kind = kind;
    }
    public ClassTypeCapture21(Class<?> kind, Map<String,Class<?>> map) {
        this.kind = kind;
        this.map = map;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typename, Class<?> kind) {
        map.put(typename, kind);
    }

    public Object createNew(String typename) throws IllegalAccessException, InstantiationException {
        if (map.containsKey(typename))
            return map.get(typename).newInstance();
        System.out.println(typename + " class not available");
        return null;
    }

    public static void main(String[] args) {
        ClassTypeCapture21<Building1> ctt1 = new ClassTypeCapture21<Building1>(Building1.class);
        print(ctt1.f(new Building1()));
        print(ctt1.f(new House1()));
        ClassTypeCapture21<House1> ctt2 = new ClassTypeCapture21<House1>(House1.class);
        print(ctt2.f(new Building1()));
        print(ctt2.f(new House1()));
        ClassTypeCapture21<Building1> ct = new ClassTypeCapture21<Building1>(Building1.class, new HashMap<>());
        ct.addType("House1", House1.class);
        ct.addType("Building1", Building1.class);
        print("ct.map = " + ct.map);
        try {
            Building1 b = (Building1) ct.createNew("Building1");
            House1 h = (House1) ct.createNew("House1");
            print("b.getClass().getName(): "
                    + b.getClass().getName());
            print("h.getClass().getName(): "
                    + h.getClass().getName());
            print("h instanceof House1: "
                    + (h instanceof House1));
            print("h instanceof Building1: "
                    + (h instanceof Building1));
            print("b instanceof Building1: "
                    + (b instanceof Building1));
            print("b instanceof House1: "
                    + (b instanceof House1));
            ct.createNew("String");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
