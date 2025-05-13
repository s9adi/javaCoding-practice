package Concurrency.Threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncAPI {
    public static void main(String[] args) {

    }

    static void AsyncApiAggregation(){
        ExecutorService executors = Executors.newFixedThreadPool(4);

        CompletableFuture<String> userCall = CompletableFuture.supplyAsync(() -> simulateCall("UserCall") , executors);

        CompletableFuture<String> orderCall = CompletableFuture.supplyAsync(() -> simulateCall("UserCall") , executors);

        CompletableFuture<String> otherCall = CompletableFuture.supplyAsync(() -> simulateCall("UserCall") , executors);

        CompletableFuture<String> result = userCall.thenCombine(orderCall , (user , order) -> user + order ).thenCombine(otherCall , (order , other) -> order + other);

    }

    static String simulateCall(String name) {
        try {
            Thread.sleep(100); // simulate delay
        } catch (InterruptedException ignored) {}
        return name + " response";
    }
}
