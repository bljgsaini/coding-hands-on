package javaPractice.executorFramework;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.*;

public class CallableAndFutureMain {
    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        PowerCalc powerCalc = new PowerCalc(5);
        Future power = executorService.submit(powerCalc);


        FactorialCalc factorialCalc = new FactorialCalc(5);
        Future factorial = executorService.submit(factorialCalc);

        try {
            System.out.println("power of 5: " + power.get());
            System.out.println("factorial of 5: " + factorial.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}


class PowerCalc implements Callable{

    double number;

    public PowerCalc(double number){
        this.number = number;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("calculating power of number " + number + "with Thread " + Thread.currentThread().getName());
        return Math.pow(number, number);
    }
}


class FactorialCalc implements Callable{

    private Double number;

    public FactorialCalc(double number){
        this.number = number;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("calculating factorial of number " + number + "with Thread " + Thread.currentThread().getName());
        double factorial = 1;
        for (int i = 1; i <=number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
