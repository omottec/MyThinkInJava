package innerclasses;

/**
 * Created by qinbingbing on 1/28/16.
 */
class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }
}

interface Selector2 {
    boolean end();
    Object current();
    void next();
}

public class Sequence2 {
    private Object[] items;
    private int next = 0;

    public Sequence2(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector2 {
        private int i = 0;
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
            if (i < items.length)
                i++;
        }
    }

    public Selector2 selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence2 sequence = new Sequence2(10);
        for (int i = 0; i < 10; i++)
            sequence.add(new Word(Integer.toString(i)));
        Selector2 selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        Word w1 = new Word("Peace");
        Word w2 = new Word("Love");
        Word w3 = new Word("Easter");
        Sequence2 message = new Sequence2(3);
        message.add(w1);
        message.add(w2);
        message.add(w3);
        Selector2 sel = message.selector();
        while (!sel.end()) {
            System.out.print(sel.current() + " ");
            sel.next();
        }
    }
}
