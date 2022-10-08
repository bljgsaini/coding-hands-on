package javaPractice.concurrency;


public class PrintSequenceUsingThreeThread8Oct2022 {

    public static void main(String[] args) {
        Counter counter = new Counter(1, 20);
        PrintSeqRunnable printSeqRunnable1 = new PrintSeqRunnable(counter, 1);
        PrintSeqRunnable printSeqRunnable2 = new PrintSeqRunnable(counter, 2);
        PrintSeqRunnable printSeqRunnable3 = new PrintSeqRunnable(counter, 0);

        Thread thread1 = new Thread(printSeqRunnable1, "First Thread");
        Thread thread2 = new Thread(printSeqRunnable2, "second Thread");
        Thread thread3 = new Thread(printSeqRunnable3, "third thread");

        thread1.start();
        thread2.start();
        thread3.start();

    }

}



class PrintSeqRunnable implements Runnable{

    Counter counter;
    int rem;

    public PrintSeqRunnable(Counter counter, int rem){
        this.counter = counter;
        this.rem = rem;
    }


    @Override
    public void run() {
        while(counter.count < counter.limit-1){
            synchronized (counter){
                while (counter.count % 3 != rem){
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " printing : " + counter.count );
                counter.count++;
                counter.notifyAll();
            }
        }
    }
}



