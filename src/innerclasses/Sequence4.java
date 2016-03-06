package innerclasses;

/**
 * Created by qinbingbing on 1/28/16.
 */
interface Selector4 {
    boolean end();
    Object current();
    void next();
}

public class Sequence4 {
    private Object[] items;
    private int next = 0;

    public Sequence4(int size) {
        items = new Object[size];
    }

    public void test() {
        System.out.println("Sequence4.test()");
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector4 {
        private int i;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) i++;
        }

        public Sequence4 sequence4() {
            return Sequence4.this;
        }
    }

    public Selector4 selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence4 sequence = new Sequence4(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector4 selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        System.out.println();
        sequence.test();
        ((SequenceSelector) selector).sequence4().test();
    }
}
