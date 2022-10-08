package javaPractice.executorFramework;

import java.util.concurrent.*;

public class FutureTaskMain {
    public static void main(String[] args) {
        MultiplyingTask multiplyingTask1 = new MultiplyingTask(5, 4, 1000);
        MultiplyingTask multiplyingTask2 = new MultiplyingTask(10, 10, 2000);


        FutureTask<Integer> futureTask1 = new FutureTask<>(multiplyingTask1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(multiplyingTask2);

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        threadPoolExecutor.execute(futureTask1);
        threadPoolExecutor.execute(futureTask2);

        while (true){

            if(!futureTask1.isDone()){
                try {
                    System.out.println("FutureTask1 output="+futureTask1.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

            if(!futureTask2.isDone()){
                try {
                    System.out.println("FutureTask2 output=" + futureTask2.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }


            if(futureTask1.isDone() && futureTask2.isDone()){
                threadPoolExecutor.shutdown();
                return;
            }


        }

    }


}


class MultiplyingTask implements Callable{

    int a,b;
    int sleepTime;

    public MultiplyingTask(int a, int b, int sleepTime){
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;

    }

    @Override
    public Object call() throws Exception {
        Thread.sleep(sleepTime);
        return a*b;
    }
}