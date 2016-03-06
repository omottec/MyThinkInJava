package innerclasses;

/**
 * Created by qinbingbing on 1/28/16.
 */
public class Outer3 {
    private String s;
    class Inner3 {
        Inner3 () {
            System.out.println("Inner3()");
        }

        @Override
        public String toString() {
            return s;
        }
    }

    Outer3(String s) {
        System.out.println("Outer3()");
        this.s = s;
    }

    Inner3 makeInner3() {
        return new Inner3();
    }

    public static void main(String[] args) {
        Outer3 o = new Outer3("Hi is risen!");
        Inner3 i = o.makeInner3();
        System.out.println(i.toString());
    }
}
