import java.util.Arrays;

public class MergeSort {
    
    // Method to sort an array using merge sort
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // Base case: an array of size 0 or 1 is already sorted
        }
        
        int mid = array.length / 2; // Find the middle index
        int[] left = Arrays.copyOfRange(array, 0, mid); // Split left half
        int[] right = Arrays.copyOfRange(array, mid, array.length); // Split right half

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);
        
        // Merge the sorted halves
        merge(array, left, right);
    }

    // Method to merge two sorted arrays into one
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0; // i for left, j for right, k for merged array
        
        // Compare elements and merge the arrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++]; // Add from left array
            } else {
                array[k++] = right[j++]; // Add from right array
            }
        }

        // If there are remaining elements in the left array
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // If there are remaining elements in the right array
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Main method to test merge sort
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10}; // Example array
        System.out.println("Original array: " + Arrays.toString(array));

        mergeSort(array); // Sort the array

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
