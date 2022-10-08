package javaPractice.concurrency;

public class Main {

    public static void main(String[] args) {
        ThreadMain threadMain = new ThreadMain();
        threadMain.start();
    }
}

class ThreadMain extends Thread{
    public void run(){
        System.out.println("Thread is running");
    }
}
