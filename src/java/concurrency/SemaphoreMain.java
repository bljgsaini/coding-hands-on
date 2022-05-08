package java.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreMain {

    public static void main(String[] args) throws InterruptedException {

        final BoundedArrayList ba = new BoundedArrayList(5);
        Runnable runnable1 = new Runnable() {

            @Override
            public void run() {
                try {
                    ba.add("John");
                    ba.add("Martin");
                    ba.add("Adam");
                    ba.add("Prince");
                    ba.add("Tod");
                    System.out.println("Available Permits : "+ba.getSemaphore().availablePermits());
                    ba.add("Tony");
                    System.out.println("Final list: "+ba.getArraylist());
                } catch (InterruptedException ie) {

                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Before removing elements: "+ ba.getArraylist());
                    Thread.sleep(5000);
                    ba.remove("Martin");
                    ba.remove("Adam");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
    }


}


class BoundedArrayList {

    private final Semaphore semaphore;
    private List arraylist;

    BoundedArrayList(int limit) {
        this.arraylist = Collections.synchronizedList(new ArrayList());
        semaphore = new Semaphore(limit);
    }

    /*
     * Add element to the list and call semaphore.acquire method
     * */
    public boolean add(Object t) throws InterruptedException {
        boolean added = false;
        semaphore.acquire();
        try {
            added = arraylist.add(t);
            return added;
        } finally {
            if (!added)
                semaphore.release();
        }

    }

    /*
     * remove element from the list and call semaphore.release method
     * */
    public boolean remove(Object t) {
        boolean wasRemoved = arraylist.remove(t);
        if (wasRemoved)
            semaphore.release();
        return wasRemoved;
    }

    public void remove(int index) {
        arraylist.remove(index);
        semaphore.release();
    }

    public List getArraylist() {
        return arraylist;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }
}
