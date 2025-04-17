package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalImpl {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {



        ExecutorService ex = Executors.newFixedThreadPool(4);
    }


}

class Task implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running" );
    }
}

