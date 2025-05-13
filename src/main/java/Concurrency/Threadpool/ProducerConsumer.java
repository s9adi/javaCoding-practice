package Concurrency.Threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Runnable producer = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.put(i);
                    Thread.sleep(100);
                    System.out.println("Produced Element " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 10; i++) {
                int x = 0;
                try {
                    x = queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Polled " + x + "from the queue");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(producer);
        pool.execute(consumer);

        pool.shutdown();
    }
}
