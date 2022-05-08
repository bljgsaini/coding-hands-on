package java.concurrency;


public class PrintSequenceUsingThreeThread {

    public static void main(String[] args) {
        PrintSequenceRunnable runnable1 = new PrintSequenceRunnable(1);
        PrintSequenceRunnable runnable2 = new PrintSequenceRunnable(2);
        PrintSequenceRunnable runnable3 = new PrintSequenceRunnable(0);

        Thread t1Thread = new Thread(runnable1, "T1");
        Thread t2Thread = new Thread(runnable2, "T2");
        Thread t3Thread = new Thread(runnable3, "T3");

        t1Thread.start();
        t2Thread.start();
        t3Thread.start();
    }

}


class PrintSequenceRunnable implements Runnable{
    static int count = 1;
    static int LIMIT = 20;
    static Object lock = new Object();
    int reminder;

    public PrintSequenceRunnable(int reminder){
        this.reminder = reminder;
    }

    @Override
    public void run() {
        synchronized (lock){
            while(count < LIMIT -1){
                while(count%3 != reminder){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + count);
                count++;
                lock.notifyAll();
            }
        }
    }
}
