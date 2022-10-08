package javaPractice.executorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class NewFixedThreadPoolMain {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            LoopTask loopTask = new LoopTask("loopTask"+i);
            threadPoolExecutor.execute(loopTask);
        }
        threadPoolExecutor.shutdown();
    }

}


class LoopTask implements Runnable{

    private String loopTaskName;

    public LoopTask(String loopTaskName){
        this.loopTaskName = loopTaskName;
    }

    @Override
    public void run() {
        System.out.println("starting "+ loopTaskName);

        for (int i = 0; i < 5; i++) {
            System.out.println("executing task: " + loopTaskName + " with thread: " + Thread.currentThread().getName());
        }

        System.out.println("ending " + loopTaskName);
    }
}
