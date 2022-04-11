package javaPractice.concurrency;

public class PrintOddEvenUsingThread {

    int max;
    int count;
    boolean odd;

    public PrintOddEvenUsingThread(int max, int count, boolean odd){
        this.max = max;
        this.count = count;
        this.odd = odd;
    }

    public static void main(String[] args) {

        PrintOddEvenUsingThread printOddEvenUsingThread = new PrintOddEvenUsingThread(19, 1, true);

        Thread oddThread = new Thread(printOddEvenUsingThread::printOdd);
        Thread evenThread = new Thread(printOddEvenUsingThread::printEven);

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Printing of element is done");


    }

    public void printOdd(){
        synchronized (this){
            while(count < max){
                while(!odd){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd thread: " + count);
                count++;
                odd = false;
                System.out.println("Notify Even:");
                notify();
            }
        }
    }


    public void printEven(){
        synchronized (this){
            while (count < max) {
                while (odd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Even thread " + count);
                count++;
                odd = true;
                System.out.println("Notify odd:");
                notify();
            }
        }
    }


}
