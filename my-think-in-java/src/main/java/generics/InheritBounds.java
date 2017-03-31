package generics;

/**
 * Created by qinbingbing on 2/9/16.
 */
class HoldItem<T> {
    T item;
    HoldItem(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
}

class Colored1<T extends HasColor> extends HoldItem<T> {

    Colored1(T item) {
        super(item);
    }

    Color color() {
        return item.getColor();
    }
}

class ColoredDimension1<T extends Dimension & HasColor> extends Colored1<T> {

    ColoredDimension1(T item) {
        super(item);
    }

    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }
}

class Solid1<T extends Dimension & HasColor & Weight> extends ColoredDimension1<T> {

    Solid1(T item) {
        super(item);
    }

    int weight() {
        return item.weight();
    }
}

public class InheritBounds {
    public static void main(String[] args) {
        Solid1<Bounded> solid1 = new Solid1<>(new Bounded());
        solid1.color();
        solid1.getY();
        solid1.weight();
    }
}
