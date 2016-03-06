package generics;

import java.util.Date;

/**
 * Created by qinbingbing on 2/12/16.
 */
interface TimeStamped {
    long getStamp();
}

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;

    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {
    long getSerialNumbered();
}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumbered() {
        return serialNumber;
    }
}

interface Color {
    String getColor();
}

class ColorImp implements Color {
    private String color = "blue";

    public void setColor(String col) {
        color = col;
    }

    @Override
    public String getColor() {
        return color;
    }
}

interface Basic {
    void set(String val);
    String get();
}

class BasicImp implements Basic {
    private String value;

    @Override
    public void set(String val) {
        value = val;
    }

    @Override
    public String get() {
        return value;
    }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered, Color {
    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    private ColorImp colorImp = new ColorImp();

    @Override
    public long getSerialNumbered() {
        return serialNumber.getSerialNumbered();
    }

    @Override
    public long getStamp() {
        return timeStamp.getStamp();
    }

    @Override
    public String getColor() {
        return colorImp.getColor();
    }
}

public class Mixins {
    public static void main(String[] args) {
        Mixin
                mixin1 = new Mixin(),
                mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " "
                + mixin1.getStamp() + " "
                + mixin1.getSerialNumbered() + " "
                + mixin1.getColor());
        System.out.println(mixin2.get() + " "
                + mixin2.getStamp() + " "
                + mixin2.getSerialNumbered() + " "
                + mixin2.getColor());
    }
}
