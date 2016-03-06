package generics;

import com.sun.tools.javac.jvm.Gen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 2/2/16.
 */
interface Selector {
    boolean end();
    Object current();
    void next();
}

public class GenericSequence<E> {
    private List<E> list = new ArrayList<>();
    private int next = 0;

    public GenericSequence(List<E> list) {
        this.list = list;
    }

    public void add(E e) {
        list.add(e);
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == list.size();
        }

        @Override
        public Object current() {
            return list.get(i);
        }

        @Override
        public void next() {
            if (i < list.size())
                i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        GenericSequence<String> gs = new GenericSequence<>(ls);
        for (int i = 0; i < 10; i++)
            gs.add(Integer.toString(i));
        Selector selector = gs.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
