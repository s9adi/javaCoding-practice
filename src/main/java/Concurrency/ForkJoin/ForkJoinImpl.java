package Concurrency.ForkJoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

public class ForkJoinImpl {

    // create the pool after Java - 7
    public static ForkJoinPool commonPool2 = new ForkJoinPool(2);

    public static void main(String[] args) {
        // using Predefined common-pool
        //  ForkJoinPool commonPool = ForkJoinPool.commonPool();

        commonPool2.execute(new CustomRecursiveAction("aditya"));


    }
}

class CustomRecursiveAction extends RecursiveAction {

    private String workload = " ";
    private static final int THRESHOLD = 4;

    private static Logger logger() {
        return Logger.getAnonymousLogger();
    }

    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        // check if the threshold is equal to length or not based on that create Subtasks
        if (workload.length() > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubTasks());
        } else {
            processing(workload);
        }
    }

    private List<CustomRecursiveAction> createSubTasks() {
        List<CustomRecursiveAction> list = new ArrayList<>();
        String part1 = workload.substring(0, workload.length() / 2);
        String part2 = workload.substring(workload.length() / 2);

        list.add(new CustomRecursiveAction(part1));
        list.add(new CustomRecursiveAction(part2));

        return list;
    }

    private void processing(String workload) {
        String result = workload.toUpperCase();
        logger().info("This Result " + " (" + " " + result + " ) was processed by " + Thread.currentThread().getName());
    }
}

class CustomRecursiveAction2 extends RecursiveAction {
    String workToBeDone = "";
    final int THRESHOLD = 2;

    public CustomRecursiveAction2(String workToBeDone) {
        this.workToBeDone = workToBeDone;
    }

    public Logger logger() {
        return Logger.getAnonymousLogger();
    }

    @Override
    protected void compute() {
        if (workToBeDone.length() > THRESHOLD) {
            // create Subtasks
            int mid = workToBeDone.length();
            CustomRecursiveAction2 task1 = new CustomRecursiveAction2(workToBeDone.substring(workToBeDone.length() / 2));
            CustomRecursiveAction2 task2 = new CustomRecursiveAction2(workToBeDone.substring(0, workToBeDone.length() / 2));

            ForkJoinTask.invokeAll(task1, task2);
        } else {
            process(workToBeDone);
        }
    }

    protected void process(String work) {
        System.out.println("Printed the String using " + Thread.currentThread().getName());
    }
}

class CustomRecursiveTask extends RecursiveTask<Integer> {

    int[] arr;
    final int THRESHOLD = 4;

    public CustomRecursiveTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
       if (arr.length > THRESHOLD){
           // create Subtasks
           CustomRecursiveTask task1 = new CustomRecursiveTask(Arrays.copyOfRange(arr , 0 , arr.length/2));
           CustomRecursiveTask task2 = new CustomRecursiveTask(Arrays.copyOfRange(arr , arr.length/2 , arr.length));

           int res1 = task1.fork().join();
           int res2 = task2.fork().join();

           return res1 + res2;

       }else {
          return process(arr);
       }
    }

    private int process(int[] arr){
        return Arrays.stream(arr).sum();
    }


}