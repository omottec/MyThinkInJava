package innerclasses;

import innerclasses.ex6Base.*;
import innerclasses.ex6Interface.*;

/**
 * Created by qinbingbing on 1/28/16.
 */
public class Ex6 extends Ex6Base {
    Ex6Interface getBaseInner() {
        return new Ex6BaseInner();
    }

    public static void main(String[] args) {
        Ex6 ex = new Ex6();
        System.out.println(ex.getBaseInner().say());
    }
}
