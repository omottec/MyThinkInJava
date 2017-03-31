package generics;
import static net.mindview.util.Print.*;
/**
 * Created by qinbingbing on 2/12/16.
 */

class PerformingDog implements Performs {

    @Override
    public void speak() {
        print("Woof!");
    }

    @Override
    public void sit() {
        print("Sitting");
    }

    public void reproduce() {

    }
}

class PerformingRobot implements Performs {

    @Override
    public void speak() {
        print("Click");
    }

    @Override
    public void sit() {
        print("Clank");
    }

    public void oilChange() {}
}

class Communicate {
    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

public class DogsAndRobots {
    public static void main(String[] args) {
        PerformingDog d = new PerformingDog();
        PerformingRobot r = new PerformingRobot();
        Communicate.perform(d);
        Communicate.perform(r);
    }
}
