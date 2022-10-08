package javaPractice.executorFramework;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorMain {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 3; i++) {
            RunnableTask runnableTask = new RunnableTask("runnableTask" + i);
            System.out.println("task scheduled at : " + new Date());
            //scheduledThreadPoolExecutor.schedule(runnableTask, 5000, TimeUnit.MILLISECONDS);
            //scheduledThreadPoolExecutor.scheduleAtFixedRate(runnableTask, 5000, 10000, TimeUnit.MILLISECONDS);
            scheduledThreadPoolExecutor.scheduleWithFixedDelay(runnableTask, 5000, 10000, TimeUnit.MILLISECONDS);
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduledThreadPoolExecutor.shutdown();
        System.out.println("All task completed!");
    }
}


class RunnableTask implements Runnable{

    private String taskName;

    public RunnableTask(String taskName){
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("task : " + taskName + "execution start time : " + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task : " + taskName + "execution end time : " + new Date());
    }
}