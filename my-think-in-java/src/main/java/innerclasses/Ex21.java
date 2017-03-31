package innerclasses;

/**
 * Created by qinbingbing on 1/29/16.
 */
interface In1 {
    String f();
    String g();
    class Nested {
        static void testIn1(In1 in1) {
            System.out.println(in1.f() + in1.g());
        }
    }
}
public class Ex21 implements In1 {
    public static void main(String[] args) {
        Ex21 x = new Ex21();
        /*Nested nested = new Nested();
        nested.testIn1(x);*/
        In1.Nested.testIn1(x);
    }

    @Override
    public String f() {
        return "hello ";
    }

    @Override
    public String g() {
        return "friend";
    }
}
