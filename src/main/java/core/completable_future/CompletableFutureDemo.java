package core.completable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 2;
        });

        try {
            Integer integer1 = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<List<Integer>> submit = service.submit(() -> {
            System.out.println("Entered the block");
            sleep();
            System.out.println(10 / 0);
            return Arrays.asList(1, 2, 3, 4);
        });

        try {
            System.out.println(submit.get());
            submit.cancel(true);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


class Example2 {

    /*
     * We simply call the method, receive the Future instance, and call the get
     * method on it when we’re ready to block for the result.
     *
     * Also, observe that the get method throws some checked exceptions, namely
     * ExecutionException (encapsulating an exception that occurred during a
     * computation) and InterruptedException (an exception signifying that a thread
     * was interrupted either before or during an activity):
     */

    // we have created a method to return future
    public static Future<String> calculateAsync() {

        /*
         * In the example below, we have a method that creates a CompletableFuture
         * instance, then spins off some computation in another thread and returns the
         * Future immediately.
         *
         * When the computation is done, the method completes the Future by providing
         * the result to the complete method:
         */

        CompletableFuture<String> comFuture = new CompletableFuture<String>();

        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            comFuture.complete("Hello it is complete");
            //return null;

        });

        return comFuture;
    }

}

