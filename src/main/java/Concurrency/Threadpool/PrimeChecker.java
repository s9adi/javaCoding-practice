package Concurrency.Threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeChecker {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Find all prime numbers between 1 and 100 using multiple threads.
        // we are calculating the prime numbers in  a bunch of threads right
        // so each thread should give a list of Future this future should have
        // the  numbers if it is prime or not
        // and all of it is collected in the List itself

        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Future<List<Integer>>> futures = new ArrayList<>();

        for (int i = 1; i <= 100; i = i + 25) {
            int start = i;
            int end = i + 24;

            Future<List<Integer>> futureOfCurrentBatch =  pool.submit(() -> {
                List<Integer> prime = new ArrayList<>();
                for (int j = start; j <= end; j++) {
                    if(isPrime(j)) prime.add(j);
                }

                return prime;
            });

            futures.add(futureOfCurrentBatch);
        }

        for (Future<List<Integer>> futureList : futures){
            System.out.println(futureList.get());
        }

        pool.shutdown();
        System.exit(1);
    }

    static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
