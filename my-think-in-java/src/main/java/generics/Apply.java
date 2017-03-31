package generics;

import sun.security.provider.SHA;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 2/12/16.
 */
public class Apply {
    public static <T, S extends Iterable<? extends T>>
            void apply(S seq, Method f, Object... arg) {
        try {
            for (T t : seq)
                f.invoke(t, arg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Shape {
    public void rotate() {
        print(this + " rotate");
    }

    public void resize(int newSize) {
        print(this + " resize " + newSize);
    }
}

class Square extends Shape {}

class FilledList<T> extends ArrayList<T> {
    public FilledList(Class<? extends T> type, int size) {
        try {
            for (int i = 0; i < size; i++)
                add(type.newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class ApplyTest {
    public static void main(String[] args) throws Exception {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            shapes.add(new Shape());
        Apply.apply(shapes, Shape.class.getMethod("rotate"));
        Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);
        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            squares.add(new Square());
        Apply.apply(squares, Shape.class.getMethod("rotate"));
        Apply.apply(squares,
                Shape.class.getMethod("resize", int.class), 5);

        Apply.apply(new FilledList<>(Shape.class, 10),
                Shape.class.getMethod("rotate"));
        Apply.apply(new FilledList<>(Square.class, 10),
                Shape.class.getMethod("rotate"));

        List<Shape> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Shape());
            list.add(new Square());
        }
        Apply.apply(list, Shape.class.getMethod("rotate"));

        SimpleQueue<Shape> shapeQ = new SimpleQueue<>();
        for (int i = 0; i < 5; i++) {
            shapeQ.add(new Shape());
            shapeQ.add(new Square());
        }
        Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
    }
}
