package innerclasses;

/**
 * Created by qinbingbing on 1/28/16.
 */
public class DotNew {
    public class Inner {}

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        Inner dni = dn.new Inner();
    }
}
