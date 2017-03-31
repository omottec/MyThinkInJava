package generics;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static net.mindview.util.Print.*;

/**
 * Created by qinbingbing on 2/13/16.
 */

interface Combiner<T> {
    T combine(T x, T y);
}

interface UnaryFunction<R,T> {
    R function(T x);
}

interface Collector<T> extends UnaryFunction<T, T> {
    T result();
}

interface UnaryPredicate<T> {
    boolean test(T x);
}

class Food {
    private String foodName = "";

    public Food() {
        foodName = "";
    }

    public Food(String name) {
        foodName = name;
    }

    public void set(String name) {
        foodName = name;
    }

    public String get() {
        return foodName;
    }

    public void eat() {
        foodName = "";
    }

    @Override
    public String toString() {
        return "Food: " + foodName;
    }
}

class Drink {
    private String drinkName = "";

    public Drink() {
        drinkName = "";
    }

    public Drink(String name) {
        drinkName = name;
    }

    public void set(String name) {
        drinkName = name;
    }

    public String get() {
        return drinkName;
    }

    public void drink() {
        drinkName = "";
    }

    @Override
    public String toString() {
        return "Drink: " + drinkName;
    }
}

public class Functional {
    public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> it = seq.iterator();
        if (it.hasNext()) {
            T result = it.next();
            while (it.hasNext())
                result = combiner.combine(result, it.next());
            return result;
        }
        return null;
    }

    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
        for (T t : seq)
            func.function(t);
        return func;
    }

    public static <T, R> List<R> transform(Iterable<T> seq, UnaryFunction<R,T> func) {
        List<R> result = new ArrayList<>();
        for (T t : seq)
            result.add(func.function(t));
        return result;
    }

    public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
        List<T> result = new ArrayList<>();
        for (T t : seq)
            if (pred.test(t))
                result.add(t);
        return result;
    }

    static class IntegerAdder implements Combiner<Integer> {

        @Override
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    static class IntegerSubtract implements Combiner<Integer> {

        @Override
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }

    static class BigDecimalAdder implements Combiner<BigDecimal> {

        @Override
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    static class BigIntegerAdder implements Combiner<BigInteger> {

        @Override
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }

    static class AtomicLongAdder implements Combiner<AtomicLong> {

        @Override
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }

    static class BigDecimalUlp implements UnaryFunction<BigDecimal, BigDecimal> {

        @Override
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }

    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
        private T bound;

        public GreaterThan(T bound) {
            this.bound = bound;
        }

        @Override
        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    static class MultiplyingIntegerCollector implements Collector<Integer> {
        private Integer val = 1;
        @Override
        public Integer result() {
            return val;
        }

        @Override
        public Integer function(Integer x) {
            return val *= x;
        }
    }

    static class MealMaker implements Combiner<Food> {

        @Override
        public Food combine(Food f1, Food f2) {
            return new Food(f1.get() + " " + f2.get());
        }
    }

    static class DrinkMaker implements Combiner<Drink> {

        @Override
        public Drink combine(Drink d1, Drink d2) {
            return new Drink(d1.get() + " " + d2.get());
        }
    }

    static class CookedMeal implements Collector<Food> {
        private Food f = new Food();

        @Override
        public Food result() {
            return new Food("cooked " + f.get());
        }

        @Override
        public Food function(Food x) {
            return f = new Food(f.get() + " " + x.get());
        }
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer result = reduce(li, new IntegerAdder());
        print(result);

        result = reduce(li, new IntegerSubtract());
        print(result);

        print(filter(li, new GreaterThan<>(4)));

        print(forEach(li, new MultiplyingIntegerCollector()).result());

        print(forEach(filter(li, new GreaterThan<>(4)),
                new MultiplyingIntegerCollector()).result());

        MathContext mc = new MathContext(7);
        List<BigDecimal> lbd = Arrays.asList(new BigDecimal(1.1, mc), new BigDecimal(2.2, mc),
                new BigDecimal(3.3, mc), new BigDecimal(4.4, mc));
        BigDecimal rbd = reduce(lbd, new BigDecimalAdder());
        print(rbd);

        print(filter(lbd, new GreaterThan<>(new BigDecimal(3))));

        List<BigInteger> lbi = new ArrayList<>();
        BigInteger bi = BigInteger.valueOf(11);
        for (int i = 0; i < 11; i++) {
            lbi.add(bi);
            bi = bi.nextProbablePrime();
        }
        print(lbi);

        BigInteger rbi = reduce(lbi, new BigIntegerAdder());
        print(rbi);
//        print(rbi.nextProbablePrime());
        print(rbi.isProbablePrime(5));

        List<AtomicLong> lal = Arrays.asList(new AtomicLong(11), new AtomicLong(47),
                new AtomicLong(74), new AtomicLong(133));
        AtomicLong ral = reduce(lal, new AtomicLongAdder());
        print(ral);

        print(transform(lbd, new BigDecimalUlp()));

        List<Food> lf = Arrays.asList(new Food("bread"), new Food("ham"),
                new Food("cheese"));
        Food meal = reduce(lf, new MealMaker());
        print(meal);
        List<Drink> ld = Arrays.asList(new Drink("water"), new Drink("orange juice"), new Drink("lemon"));
        Drink drink = reduce(ld, new DrinkMaker());
        print(drink);
        print(forEach(lf, new CookedMeal()).result());
    }
}
