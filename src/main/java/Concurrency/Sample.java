package Concurrency;

import java.util.Map;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
        // Minimum and max of an Array
        int[] arr = new int[]{5, 6, 1, 2, 9, 10};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }


        System.out.println("Max" + max + "\n" + "Min" + min);
    }
}
