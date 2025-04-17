package programming.DSA;

import java.util.Arrays;

public class LC238ProductOfArrayExceptSelf {

    public static void main(String[] args) {
//        Input: nums = [1,2,3,4]
//        Output: [24,12,8,6]

        Solution(new int[]{1, 2, 3, 4});

    }

    private static void Solution(int[] arr) {
        // at a given point the product is equal to the product of left elements and right elements
        int[] output = new int[arr.length];
        int left = 1;
        int right = 1;
        for (int i = 0; i < arr.length; i++) {
            output[i] = left;
            left = left * arr[i];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            output[i] = right * output[i];
            right = right * arr[i];
        }
        Arrays.stream(output).forEach(System.out::println);
    }
}
