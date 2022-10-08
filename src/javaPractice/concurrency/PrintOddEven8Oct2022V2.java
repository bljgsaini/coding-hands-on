package javaPractice.concurrency;

public class PrintOddEven8Oct2022V2 {
    public static void main(String[] args) {
        Counter counter = new Counter(1, 20);
        OddEvenRunnable evenRunnable = new OddEvenRunnable(counter, 0);
        OddEvenRunnable oddRunnable = new OddEvenRunnable(counter, 1);

        Thread evenThread = new Thread(evenRunnable, "Even Thread");
        Thread oddThread = new Thread(oddRunnable, "Odd Thread");

        oddThread.start();
        evenThread.start();

    }
}


class OddEvenRunnable implements Runnable{

    Counter counter;
    int rem;
    public OddEvenRunnable(Counter counter, int rem){
        this.counter = counter;
        this.rem = rem;
    }

    @Override
    public void run() {
        while(counter.count < counter.limit){
            synchronized (counter){
                while(counter.count %2 != rem ){
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " printing : " + counter.count);
                counter.count++;
                counter.notifyAll();
            }
        }
    }
}

class Counter{
    int count;
    int limit;
    public Counter(int count, int limit){
        this.count = count;
        this.limit = limit;
    }
}
