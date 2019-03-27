package concurrent;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * Created by qinbingbing on 27/03/2019.
 */
class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        Thread thread = Thread.currentThread();
        try {
            System.out.println("thread run TaskWithResult " + id + " isInterrupted " + thread.isInterrupted());
            if (id == 5 || id == 7)
                new Timer(false).schedule(new TimerTask() {
                    @Override
                    public void run() {
                        thread.interrupt();
                        System.out.println("thread run TaskWithResult " + id + " isInterrupted " + thread.isInterrupted());
                    }
                }, 1000);
            TimeUnit.MILLISECONDS.sleep(id * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("thread run TaskWithResult " + id + " isInterrupted " + thread.isInterrupted());
            return "null";
        }
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println("main thread id " + mainThread.getId());
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            results.add(exec.submit(new TaskWithResult(i)));
        new Timer(false).schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer task thread id " + Thread.currentThread().getId());
            }
        }, 6000);
        for (int i = 0; i < results.size(); i++) {
            try {
                System.out.println("get " + i);
                System.out.println(results.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                if (!exec.isShutdown()) {
                    System.out.println("shutdown");
                    exec.shutdown();
                }
            }
        }
    }
}
