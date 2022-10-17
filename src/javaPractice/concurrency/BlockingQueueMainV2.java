package javaPractice.concurrency;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueMainV2 {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        ProducerV2 producerRunnable = new ProducerV2(queue);
        ConsumerV2 consumerRunnable = new ConsumerV2(queue);

        new Thread(producerRunnable).start();
        new Thread(consumerRunnable).start();

    }

}


class ProducerV2 implements Runnable{

    BlockingQueue<String> blockingQueue;

    public ProducerV2(BlockingQueue queue){
        super();
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        for(int i=0; i<50; i++){
            try {
                blockingQueue.put("put" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class ConsumerV2 implements Runnable{

    BlockingQueue<String> queue;

    public ConsumerV2(BlockingQueue queue){
        super();
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("consume item from queue =>" + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}