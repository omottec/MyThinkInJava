package innerclasses;

/**
 * Created by qinbingbing on 1/29/16.
 */
public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface {

        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
