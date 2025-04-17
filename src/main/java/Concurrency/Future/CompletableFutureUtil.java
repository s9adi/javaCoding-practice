package Concurrency.Future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureUtil {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> cf1 = getFutureString();
        CompletableFuture<Integer> cf2 = getFutureInt();

        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1, cf2);

        System.out.println(cf.state());

        Thread.sleep(7000);

        System.out.println(cf.state());

    }

    static CompletableFuture<Integer> getFutureInt() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(6000);
                return 5;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    static CompletableFuture<String> getFutureString() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(6000);
                return "Aditya Sharma is great guy";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    static Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Future<Object> hello = Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }
}
