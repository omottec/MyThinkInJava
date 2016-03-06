package generics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 2/8/16.
 */
class Building2 {}

class House2 extends Building2 {
    private String location;
    private Integer area;
    public House2() {
        location = null;
    }
    public House2(Integer area) {
        this.area = area;
    }

    public House2(String location) {
        this.location = location;
    }

    public House2(String location, Integer area) {
        this.location = location;
        this.area = area;
    }

    @Override
    public String toString() {
        return "House2"
                + ((location == null) ? "" :  " in " + location)
                + ((area != null) ? ", " + area + " sqft" : "");
    }
}

public class ClassTypeCreator22<T> {
    Class<T> kind;
    public ClassTypeCreator22(Class<T> kind) {
        this.kind = kind;
    }
    public Object createNew(String typeName)
            throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {
        return Class.forName(typeName).newInstance();
    }
    public Object createNew(String typeName, Object... args)
            throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        switch (args.length) {
            case 1 : return Class.forName(typeName).getConstructor(args[0].getClass()).newInstance(args[0]);
            case 2 : return Class.forName(typeName).getConstructor(args[0].getClass(), args[1].getClass())
                    .newInstance(args[0], args[1]);
        }
        return null;
    }

    public static void main(String[] args) {
        ClassTypeCreator22<Building2> ctcb = new ClassTypeCreator22<>(Building2.class);
        ClassTypeCreator22<House2> ctch = new ClassTypeCreator22<>(House2.class);
        try {
            Building2 b = (Building2) ctcb.createNew("generics.Building2");
            print("House constructors:");
            Constructor[] ctors = House2.class.getConstructors();
            for (Constructor ctor : ctors) print(ctor);
            House2 h = (House2) ctch.createNew("generics.House2", "Hawaii");
            House2 h2 = (House2) ctch.createNew("generics.House2", 3000);
            House2 h3 = (House2) ctch.createNew("generics.House2", "Manila", 5000);
            print("Constructed House Objects:");
            print(h);
            print(h2);
            print(h3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
