package generics;

import java.util.HashMap;
import java.util.Map;
import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 2/9/16.
 */
interface Factory3<T> {
    T create();
}

class Building3 {}

class House3 extends Building3 {}

class BuildingFactory3 implements Factory3<Building3> {

    @Override
    public Building3 create() {
        return new Building3();
    }
}

class HouseFactory3 implements Factory3<House3> {

    @Override
    public House3 create() {
        return new House3();
    }
}

public class ClassTypeCapture24<T> {
    Class<?> kind;
    public ClassTypeCapture24(Class<?> kind) {
        this.kind = kind;
    }
    Map<String, Factory3> map;
    public ClassTypeCapture24(Class<?> kind, Map<String, Factory3> map) {
        this.kind = kind;
        this.map = map;
    }
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typename, Factory3 factory) {
        map.put(typename, factory);
    }

    public Object createNew(String typename) {
        if (map.containsKey(typename))
            return map.get(typename).create();
        System.out.println(typename + " class not available");
        return null;
    }

    public static void main(String[] args) {
        ClassTypeCapture24<Building3> ctt1 = new ClassTypeCapture24<Building3>(Building3.class);
        print(ctt1.f(new Building3()));
        print(ctt1.f(new House3()));
        ClassTypeCapture24<House3> ctt2 = new ClassTypeCapture24<House3>(House3.class);
        print(ctt2.f(new Building3()));
        print(ctt2.f(new House3()));
        ClassTypeCapture24<Building3> ct = new ClassTypeCapture24<Building3>(Building3.class, new HashMap<String, Factory3>());
        ct.addType("House3", new HouseFactory3());
        ct.addType("Building3", new BuildingFactory3());
        print("ct.map = " + ct.map);
        Building3 b = (Building3) ct.createNew("Building3");
        House3 h = (House3) ct.createNew("House3");
        print("b.getClass().getName(): " + b.getClass().getName());
        print("h.getClass().getName(): " + h.getClass().getName());
        print("h instanceof House3: " + (h instanceof House3));
        print("h instanceof Building3: " + (h instanceof Building3));
        print("b instanceof Building3: " + (b instanceof Building3));
        print("b instanceof House3: " + (b instanceof House3));
        ct.createNew("String");
    }
}
