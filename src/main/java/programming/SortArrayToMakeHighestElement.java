package programming;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortArrayToMakeHighestElement {

    public static void main(String[] args) {
        Solution();
    }

    public static void Solution() {
        String[] array = {"12", "34", "67", "64", "9", "90"};
        // sort the array and then make the highest number
        Arrays.sort(array, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });
        String collect = Arrays.stream(array).collect(Collectors.joining());
        System.out.println(collect);


    }
}
