package generics;

import java.lang.reflect.Method;

import static net.mindview.util.Print.*;
/**
 * Created by qinbingbing on 2/12/16.
 */

class Mime {
    public void walkAgainstTheWind() {}

    public void sit() {
        print("Pretending to sit");
    }

    public void pushInvisibleWalls() {}

    @Override
    public String toString() {
        return "Mine";
    }
}

class SmartDog {
    public void speak() {
        print("Woof!");
    }

    public void sit() {
        print("Sitting");
    }

    public void reproduce() {}
}

class CommunicateReflectively {
    public static void perform(Object obj) {
        Class<?> clazz = obj.getClass();
        try {
            try {
                Method speak = clazz.getMethod("speak");
                speak.invoke(obj);
            } catch (NoSuchMethodException e) {
                print(obj + " cannot speak");
            }
            try {
                Method sit = clazz.getMethod("sit");
                sit.invoke(obj);
            } catch (NoSuchMethodException e) {
                print(obj + " cannot sit");
            }
        } catch (Exception e) {
            throw new RuntimeException(obj.toString(), e);
        }
    }
}

public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new PerformingRobot());
        CommunicateReflectively.perform(new Mime());
    }
}
