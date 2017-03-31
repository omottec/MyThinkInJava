package generics;
import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 2/11/16.
 */
public class Holders30 {
    public static void main(String[] args) {
        Holder<Character> charHolder = new Holder<>();
        Holder<Byte> byteHolder = new Holder<>();
        Holder<Short> shortHolder = new Holder<>();
        Holder<Integer> intHolder = new Holder<>();
        Holder<Long> longHolder = new Holder<>();
        Holder<Float> floatHolder = new Holder<>();
        Holder<Double> doubleHolder = new Holder<>();
        charHolder.set('a');
        printnb(charHolder.get() + ", ");
        print(charHolder.get().getClass());
        char c = charHolder.get();
        print("char c = charHolder.get() =  " + c);
        byte b = 1;
        byteHolder.set(b);
        printnb(byteHolder.get() + ", ");
        print(byteHolder.get().getClass());
        byte bb = byteHolder.get();
        print("byte bb = byteHolder.get() = " + bb);
        short s = 1;
        shortHolder.set(s);
        printnb(shortHolder.get() + ", ");
        print(shortHolder.get().getClass());
        short ss = shortHolder.get();
        print("short ss = shortHolder.get() = " + ss);
        intHolder.set(1);
        printnb(intHolder.get() + ", ");
        print(intHolder.get().getClass());
        int i = intHolder.get();
        print("int i = intHolder.get() = " + i);
        long l = 2;
        longHolder.set(l);
        printnb(longHolder.get() + ", ");
        print(longHolder.get().getClass());
        long ll = longHolder.get();
        print("long ll = longHolder.get() = " + ll);
        float f = 1f;
        floatHolder.set(f);
        printnb(floatHolder.get() + ", ");
        print(floatHolder.get().getClass());
        float ff = floatHolder.get();
        print("float ff = floatHolder.get() = " + ff);
        double d = 1.1;
        doubleHolder.set(d);
        printnb(doubleHolder.get() + ", ");
        print(doubleHolder.get().getClass());
        double dd = doubleHolder.get();
        print("double dd = doubleHolder.get() = "+ dd);
    }
}
