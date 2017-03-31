package innerclasses;

/**
 * Created by qinbingbing on 1/28/16.
 */
public class Outer7 {
    private int oi = 1;
    private void hi() {
        System.out.println("Outer Hi");
    }

    class Inner {
        void modifyOut() {
            oi *= 2;
            hi();
        }
    }

    public void showOi() {
        System.out.println(oi);
    }

    void testInner() {
        Inner in = new Inner();
        in.modifyOut();
    }

    public static void main(String[] args) {
        Outer7 out = new Outer7();
        out.showOi();
        out.testInner();
        out.showOi();
        Inner inner = out.new Inner();
        inner.modifyOut();
        out.showOi();
    }
}
