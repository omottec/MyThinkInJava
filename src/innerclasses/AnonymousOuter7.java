package innerclasses;

/**
 * Created by qinbingbing on 1/29/16.
 */
public class AnonymousOuter7 {
    private int oi = 1;

    private void hi() {
        System.out.println("Outer Hi");
    }

    public void showOi() {
        System.out.println(oi);
    }

    void testAnonymousInner() {
        new AnonymousOuter7() {
            {
                oi *= 2;
                hi();
            }
        };
    }

    public static void main(String[] args) {
        AnonymousOuter7 out = new AnonymousOuter7();
        out.showOi();
        out.testAnonymousInner();
        out.showOi();
    }

}
