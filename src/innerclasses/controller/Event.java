package innerclasses.controller;

/**
 * Created by qinbingbing on 1/29/16.
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() {
        eventTime = System.currentTimeMillis() + delayTime;
    }

    public boolean ready() {
        return System.currentTimeMillis() >= eventTime;
    }

    public abstract void action();
}
