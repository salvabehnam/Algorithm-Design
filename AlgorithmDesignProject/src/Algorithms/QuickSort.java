package Algorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// Java program for implementation of QuickSort
public class QuickSort {

    // This function takes last element as pivot, places the pivot element at its correct position in sorted array, and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // The main function that implements QuickSort() arr[] --> Array to be sorted, low --> Starting index, high --> Ending index
    private void sort(int[] arr, int low, int high) {
        if (low < high) {
			// p is partitioning index, arr[p] is now at right place
            int p = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            sort(arr, low, p-1);
            sort(arr, p+1, high);
        }
    }

    /* A utility function to print array of size n */
    private static void printArray(int[] arr, String path) throws IOException {
        FileWriter outFile = new FileWriter(path);
        for (int value : arr){
            System.out.print(value + " ");
            outFile.write(value + " ");
        }
        System.out.println();
        outFile.write("\n");
    }

    // Driver program
    public static void start(String path) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Array Type a character to end");
        ArrayList<Integer> a = new ArrayList<>();

        while (scanner.hasNextInt()) a.add(scanner.nextInt());

        int[] array = a.stream().filter(Objects::nonNull).mapToInt(i -> i).toArray();

        new QuickSort().sort(array, 0, array.length);

        System.out.println("sorted array");
        printArray(array, path);
    }
}