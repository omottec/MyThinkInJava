package concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qinbingbing on 27/03/2019.
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
//        List<Runnable> runnableList = exec.shutdownNow();
//        System.out.println(Arrays.toString(runnableList.toArray()));
    }
}
