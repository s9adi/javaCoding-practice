package Concurrency.Threadpool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelLineCounter {

    public static void main(String[] args) {

    }

    static void Solution() {

        List<File> files = List.of(new File("file1.txt"), new File("file2.txt"), new File("file3.txt"));

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Integer>> futures = new ArrayList<>();

        for (File file : files) {
            // traversing each file and then adding that to the list of the future
            futures.add(pool.submit(() -> {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    int lines = 0;
                    while (br.readLine() != null) lines++;
                    return lines;
                }
            }));
        }

        int totLines = 0;
        for (int i = 0; i < futures.size(); i++) {
            totLines = totLines + futures.size();
        }

        pool.shutdown();
        System.out.println("Total Lines " + totLines);
    }
}
