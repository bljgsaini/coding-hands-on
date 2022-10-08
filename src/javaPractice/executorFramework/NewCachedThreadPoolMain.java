package javaPractice.executorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class NewCachedThreadPoolMain {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            ReadDataFromFile readDataFromFile = new ReadDataFromFile("fileName"+ i);
            threadPoolExecutor.execute(readDataFromFile);
        }
        threadPoolExecutor.shutdown();
    }

}


class ReadDataFromFile implements Runnable{

    private String fileName;

    public ReadDataFromFile(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("Reading data from file" + fileName + " by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Reading done from file" + fileName + " by thread " + Thread.currentThread().getName());
    }

    public String getFileName(){
        return fileName;
    }

}