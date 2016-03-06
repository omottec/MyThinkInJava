package innerclasses;

/**
 * Created by qinbingbing on 1/29/16.
 */

public class Ex9Anonymous {
    Ex9Interface f() {
        return new Ex9Interface() {
            @Override
            public void say(String s) {
                System.out.println(s);
            }
        };
    }

    public static void main(String[] args) {
        Ex9Anonymous x = new Ex9Anonymous();
        x.f().say("hi");
    }
}
