package generics;

/**
 * Created by qinbingbing on 2/10/16.
 */
interface A1 {}

interface B1 {}

class C1 implements A1, B1 {
    @Override
    public String toString() {
        return "C1";
    }
}

public class Ex25 {
    <T extends A1> void a(T t) {
        System.out.println("a(" + t + ")");
    }

    <T extends B1> void b(T t) {
        System.out.println("b(" + t + ")");
    }

    public static void main(String[] args) {
        C1 c1 = new C1();
        Ex25 ex = new Ex25();
        ex.a(c1);
        ex.b(c1);
    }
}
