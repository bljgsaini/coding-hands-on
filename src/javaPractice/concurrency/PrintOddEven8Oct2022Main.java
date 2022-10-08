package javaPractice.concurrency;

public class PrintOddEven8Oct2022Main {

    public static void main(String[] args) {
        Counter counter = new Counter(1, 10);
        int maxLimit = 10;

        PrintEven printEvenThread = new PrintEven(maxLimit, counter);
        PrintOdd printOddThread = new PrintOdd(maxLimit, counter);

        Thread threadEven = new Thread(printEvenThread, "print even");
        Thread threadOdd = new Thread(printOddThread, "print odd");
        threadEven.start();
        threadOdd.start();

        try {
            threadOdd.join();
            threadEven.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}




class PrintEven implements Runnable{

    int maxLimit;
    Counter counter;

    public PrintEven(int maxLimit, Counter counter){
        this.maxLimit= maxLimit;
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter){
            while(counter.count < maxLimit){
                while(counter.count%2 == 1) {
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("PrintEven printing : " + counter.count);
                counter.count++;
                counter.notify();
            }
        }
    }
}


class PrintOdd implements Runnable{

    int maxLimit;
    Counter counter;

    public PrintOdd(int maxLimit, Counter counter){
        this.maxLimit= maxLimit;
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter){
            while(counter.count < maxLimit){
                while(counter.count%2 == 0) {
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("PrintOdd printing : " + counter.count);
                counter.count++;
                counter.notify();
            }
        }
    }
}

