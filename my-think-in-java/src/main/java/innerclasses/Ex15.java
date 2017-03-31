package innerclasses;

/**
 * Created by qinbingbing on 1/29/16.
 */

class One {
    private String s;
    One(String s) {
        this.s = s;
    }
    public String showS() {
        return s;
    }
}

public class Ex15 {
    public One makeOne(String s) {
        return new One(s) {};
    }

    public static void main(String[] args) {
        Ex15 x = new Ex15();
        System.out.println(x.makeOne("hi").showS());;
    }
}
