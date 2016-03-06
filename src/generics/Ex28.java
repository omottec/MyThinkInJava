package generics;

/**
 * Created by qinbingbing on 2/10/16.
 */
public class Ex28 {
    class Generic1<T> {
        T t;
        void take(T t) {
            this.t = t;
        }
    }

    class Generic2<T> {
        T t;
        T give() { return t; }
    }

    <T> void contra(Generic1<? super T> g1t, T t) {
        g1t.take(t);
    }

    <T> T co(Generic2<? extends T> g2t) {
        return g2t.give();
    }

    public static void main(String[] args) {
        Ex28 e28 = new Ex28();
        e28.contra(e28.new Generic1<Fruit>(), new Apple());
        Fruit f = e28.co(e28.new Generic2<Fruit>());
    }
}
