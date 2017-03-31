package access;

/**
 * Created by qinbingbing on 1/28/16.
 */
public class AccessTest {
    public static void main(String[] args) {
        FourWays fw = new FourWays();
        fw.showA();
        fw.showB();
        fw.showC();
//        fw.showD();
        fw.a = 10;
        fw.b = 20;
        fw.c = 30;
        fw.showA();
        fw.showB();
        fw.showC();
    }
}
