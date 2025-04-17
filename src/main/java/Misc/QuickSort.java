package Misc;

public class QuickSort {

    /*
    We find the partition index
    and then we quick sort the two parts again
     */

    static void quickSort(int[] arr, int high, int low) {
        if (low < high) {
            int k = partition(arr, arr.length, 0);
            quickSort(arr, k, 0);
            quickSort(arr, k + 1, high);
        }
    }

    static int partition(int[] arr, int high, int low) {
        // we chose the pivot to be the first element
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i < j) swap(arr, i, j);
        }
        // swap the pivot to its original location
        swap(arr, low, j);
        return j;
    }

    static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
