package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinbingbing on 2/11/16.
 */
interface IProcessor<T, E extends Exception, E2 extends Exception> {
    void process(List<T> resultCollector) throws E,E2;
}

class ProcessRunner1<T, E extends Exception, E2 extends Exception> extends ArrayList<IProcessor<T,E,E2>> {
    List<T> processAll() throws E, E2 {
        List<T> resultCollector = new ArrayList<>();
        for (IProcessor<T,E,E2> processor : this)
            processor.process(resultCollector);
        return resultCollector;
    }
}

class Failure3 extends Exception {}

class Failure4 extends Exception {}

class Processor3 implements IProcessor<String, Failure3, Failure4> {
    static int count = 3;

    @Override
    public void process(List<String> resultCollector) throws Failure3, Failure4 {
        if (count-- > 1)
            resultCollector.add("Hep!");
        else
            resultCollector.add("Ho!");
        if (count < 0)
            throw new Failure3();
        if (count < -1)
            throw new Failure4();
    }
}

class Processor3b implements IProcessor<String, Failure3, Failure4> {
    static int count = 3;
    @Override
    public void process(List<String> resultCollector) throws Failure3, Failure4 {
        if (count-- > 1)
            resultCollector.add("Hep!");
        else
            resultCollector.add("Ho!");
        if (count < 0)
            throw new Failure3();
        if (count == 1)
            throw new Failure4();
    }
}

class Failure5 extends Exception {}

class Processor4 implements IProcessor<Integer, Failure4, Failure5> {
    static int count = 2;
    @Override
    public void process(List<Integer> resultCollector) throws Failure4, Failure5 {
        if (count-- == 0)
            resultCollector.add(47);
        else
            resultCollector.add(11);
        if (count < 0)
            throw new Failure4();
        if (count < -1)
            throw new Failure5();
    }
}

class Processor4b implements IProcessor<Integer, Failure4, Failure5> {
    static int count = 2;
    @Override
    public void process(List<Integer> resultCollector) throws Failure4, Failure5 {
        if (count-- == 0)
            resultCollector.add(47);
        else
            resultCollector.add(11);
        if (count < 0)
            throw new Failure4();
        if (count == 1)
            throw new Failure5();
    }
}

public class ThrowGenericException36 {
    public static void main(String[] args) {
        ProcessRunner1<String, Failure3, Failure4> runner =
                new ProcessRunner1<>();
        for (int i = 0; i < 3; i++)
            runner.add(new Processor3());
        try {
            System.out.println(runner.processAll());
        } catch (Failure3 e) {
            e.printStackTrace();
        } catch (Failure4 e) {
            e.printStackTrace();
        }

        ProcessRunner1<String, Failure3, Failure4> runnerb =
                new ProcessRunner1<>();
        for (int i = 0; i < 3; i++)
            runnerb.add(new Processor3b());
        try {
            System.out.println(runnerb.processAll());
        } catch (Failure3 e) {
            e.printStackTrace();
        } catch (Failure4 e) {
            e.printStackTrace();
        }

        ProcessRunner1<Integer, Failure4, Failure5> runner1 =
                new ProcessRunner1<>();
        for (int i = 0; i < 3; i++)
            runner1.add(new Processor4());
        try {
            System.out.println(runner1.processAll());
        } catch (Failure4 e) {
            e.printStackTrace();
        } catch (Failure5 e) {
            e.printStackTrace();
        }

        ProcessRunner1<Integer, Failure4, Failure5> runner1b =
                new ProcessRunner1<>();
        for (int i = 0; i < 3; i++)
            runner1b.add(new Processor4b());
        try {
            System.out.println(runner1b.processAll());
        } catch (Failure4 e) {
            e.printStackTrace();
        } catch (Failure5 e) {
            e.printStackTrace();
        }
    }
}