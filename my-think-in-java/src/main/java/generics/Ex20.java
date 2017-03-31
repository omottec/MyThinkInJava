package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 2/7/16.
 */
interface IA {
    void f();
    void g();
}

class A3 implements IA {
    @Override
    public void f() {
        System.out.println("A3.f()");
    }

    @Override
    public void g() {
        System.out.println("A3.g()");;
    }

    public void h() {
        System.out.println("A3.h()");
    }
}

class G {
    public static <T extends IA> void j(T x) {
        x.f();
        x.g();
    }
}

public class Ex20 {
    public static void main(String[] args) {
        A3 a3 = new A3();
        G.j(a3);
        List<String> ls = new ArrayList<>();
        List list = new ArrayList<>();
//        ls = list;
        list = ls;
    }
}
