import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {

    }


}

class ConsumerFactory{

    public static Consumer getConsumer(String type, Queue<Integer>queue){
        if(type.equals("oddConsumer")){
            return new OddConsumer(queue);
        }else if(type.equals("evenConsumer")){
            return new EvenConsumer(queue);
        }
        return null;
    }

}

class OddConsumer implements Consumer, Runnable{

    private final Queue<Integer> queue;

    OddConsumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    public synchronized int consumeData(){
        while(!queue.isEmpty() && queue.peek()%2 == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(queue.isEmpty()) return -1;
        System.out.println("Odd Thread: data: " + queue.peek() );
        return queue.poll();
    }

    @Override
    public void run() {
        consumeData();
    }
}

class EvenConsumer implements Consumer, Runnable{

    private final Queue<Integer> queue;

    EvenConsumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    public synchronized int consumeData(){
        while( queue.isEmpty() ){
            try {
                wait();
                //Thread.sleep(1000); // wait notify, notifyAll
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while( queue.peek()%2 != 0 ){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(queue.isEmpty()) return -1;
        System.out.println("Even Thread: data: " + queue.peek() );
        return queue.poll();
    }

    @Override
    public void run() {
        consumeData();
    }
}




 interface Consumer{
    public int consumeData();
}

class Producer implements Runnable{

    private final Queue queue;

    Producer(Queue<Integer> queue){
        this.queue = queue;
    }

    public synchronized void addMessage(int data) {
        while (queue.size() == 100 ){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(data);
    }

    @Override
    public void run() {
        int i =0;
        while (true){
            addMessage(i++);
        }
    }
}

