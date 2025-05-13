package Interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Concurrent_Sample {

    static int totalTasks = 1000;
    static int threadPoolSize = 5;
    static int batchSize = 10;

    // 10 Tasks at a time , Thread-pool of 5 threads , process 1000 tasks
    public static void main(String[] args) {


    }

    static void usingCallableAndFuture() {

        ExecutorService pool = Executors.newFixedThreadPool(threadPoolSize);
        List<Future<List<Integer>>> finalRes = new ArrayList<>();

        // Using Callable
        // run from the start to the end and if the number is found to be prime then we are going to store the result in the Future Object

        for (int i = 0; i < totalTasks; i = i + batchSize) {

            int start = i;
            int end = i + batchSize;

            // Callable task to find the prime number in the batch
            Future<List<Integer>> futureResult = pool.submit(() -> {
                List<Integer> primeNums = new ArrayList<>();
                for (int j = start; j < end; j++) {
                    if (isPrime(j)) primeNums.add(j);
                }

                return primeNums;
            });

            finalRes.add(futureResult);
        }
    }

    static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i < num; i++) {
            if ((num % i == 0)) return false;
        }
        return true;
    }

    // modified for Concurrent Operations using CompletableFuture


    static void usingCompletableFuture() {

        ExecutorService pool = Executors.newFixedThreadPool(threadPoolSize);
        // we have to operate this concurrently in batches
        // each batches are running in different Completable Future Task (Thread)

        List<CompletableFuture<List<Integer>>> resultOfBatchOps = new ArrayList<>();

        for (int i = 0; i < totalTasks; i = i + batchSize) {
            int start = i;
            int end = i + batchSize;



            CompletableFuture<List<Integer>> result =  CompletableFuture.supplyAsync(() -> {
                List<Integer> primNums = new ArrayList<>();
                for (int j = start ; j < end ; j++){
                    if(isPrime(j)) primNums.add(j);
                }

                return primNums;
            });

            resultOfBatchOps.add(result);
        }

        pool.shutdown();
    }

}
