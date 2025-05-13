package Concurrency.Threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

public class RetryMechanism {
    // Retry an API call 3 times with delay if it fails (simulate failure).

    public static void main(String[] args) {

    }

    /*
    Handle always handle the output either exception or the result of the operations that were performed
    and handles always return the CompletableFuture<U> after the computation
    runasync or supplyasync also returns the CompletableFuture<U>

    Therefore the output of the one iteration of runasync and the handle will be Completable<Completable<U>> , without
    compose you would have to write .get().get() to get the output value

    handle does not always return the nested Completable future but in this case we have the retry mechanism in the
    handle method that is why it is returning the nested
     */

    static CompletableFuture<Void> retryAsync(Supplier<Void> task, int retries, int delayMillis, Executor executor) {
        return CompletableFuture.supplyAsync(task, executor) // gives the future result of the operations when the iterations complete
                .handle((res, ex) -> { // handle result the completable future but the collective
                    if (ex == null)
                        return CompletableFuture.completedFuture(null);  // operation result the nested Completable Future
                    if (retries > 0) {
                        // retries
                        System.out.println("Retrying the attempts " + retries + " left ");
                        try {
                            Thread.sleep(6000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        return retryAsync(task, retries, delayMillis, executor);
                    } else throw new CompletionException(ex);
                }).thenCompose(f -> (CompletableFuture<Void>) f);
    }

}
