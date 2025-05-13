package Concurrency.Threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class BatchTasks {
    public static void main(String[] args) {

    }

    static void usingCompletableFuture() {
        int batchSize = 10;
        int poolSize = 5;
        int[] arr = IntStream.rangeClosed(1, 1000).toArray();

        ExecutorService pool = Executors.newFixedThreadPool(poolSize);

        List<CompletableFuture<Void>> allBatchFutures = new ArrayList<>();
        for (int i = 0; i < arr.length; i = i + batchSize) {
            int start = i;
            int end = Math.min(i + batchSize, arr.length);

            List<CompletableFuture<Void>> batchFutures = new ArrayList<>();

            for (int j = start; j < end; j++) {
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    System.out.println("Element " + " printed by " + Thread.currentThread().getName());
                }, pool);

                batchFutures.add(future);
            }

            // so we have the completable future so far of the batch itself

            CompletableFuture<Void> batchFuture = CompletableFuture.allOf(batchFutures.toArray(new CompletableFuture[0]));
            batchFuture.thenRun(() -> System.out.println("Completed Batch from Index  " + start + " to " + end));
            allBatchFutures.add(batchFuture);
        }

        CompletableFuture<Void> allCompletedFuture = CompletableFuture.allOf(allBatchFutures.toArray(new CompletableFuture[0]));
        allCompletedFuture.join(); // blocked
        pool.shutdown();
    }

    static void usingCallable() throws InterruptedException {
        int batchSize = 10;
        int poolSize = 5;
        int tasksSize = 1_000_000;

        ExecutorService pool = Executors.newFixedThreadPool(poolSize);

        // since millions of tasks are there we need to store the result of each, we first create DS to store the
        // tasks
        List<Callable<Void>> taskList = new ArrayList<>();

        // create dummy tasks

        for (int i = 0; i < tasksSize; i++) {
            int taskId = i;
            taskList.add(() -> {
                System.out.println("Callable Task executing taskId " + taskId + " by thread = " + Thread.currentThread().getName());
                Thread.sleep(100);
                return null;
            });
        }

        // so far we have created the dummy tasks , now we need to execute them and store the outcome of each
        // execute them by each different thread

        for (int i = 0; i < taskList.size(); i = i + batchSize) {
            int end = Math.min(i + batchSize, tasksSize);
            int start = i;

            List<Callable<Void>> batch = taskList.subList(start, end);
            List<Future<Void>> futures = pool.invokeAll(batch);

            for (Future<Void> future : futures) {
                try {
                    future.get();
                } catch (Exception e) {
                    System.out.println("Exception message : " + e);
                }
            }

            System.out.println("Completed batch from  " + start + " to " + end);
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("All Tasks are completed now ");

    }

    static void usingCompletable() {
        int batch = 10;
        int poolSize = 5;
        int tasks = 1_000;

        List<CompletableFuture<Void>> allBatchTasks = new ArrayList<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(poolSize);

        for (int i = 0; i < tasks; i = i + batch) {
            int start = 0;
            int end = Math.min(i + batch, tasks);

            // now execute the tasks from start to end

            List<CompletableFuture<Void>> batchTasks = new ArrayList<>();

            for (int j = start; j < end; j++) {
                int taskId = j;
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    System.out.println("Executing the tasks with taskId " + taskId + " from Thread " + Thread.currentThread().getName());
                }, threadPool);
                batchTasks.add(future);
            }

            CompletableFuture<Void> allOfBatch = CompletableFuture.allOf(batchTasks.toArray(new CompletableFuture[0]))
                    .thenRun(() -> System.out.println("Completed the batch from " + start + " to " + end));

            allBatchTasks.add(allOfBatch);
        }

        CompletableFuture<Void> allOfAllFutures = CompletableFuture.allOf(allBatchTasks.toArray(new CompletableFuture[0]));
        allOfAllFutures.join();
        threadPool.shutdown();

        System.out.println("All Tasks Done");
    }
}
