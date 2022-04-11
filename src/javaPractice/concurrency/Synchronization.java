package javaPractice.concurrency;

public class Synchronization {
}


class RequestCounter {
    private int count;
    public synchronized int incrementCount()
    {
        count++;
        return count;
    }
}

class RequestCounter1 {

    private int count;

    public int incrementCount() {
        synchronized (this) {
            count++;
            return count;
        }
    }
}
