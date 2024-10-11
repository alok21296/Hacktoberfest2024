import java.util.Arrays;

public class QuickSort {

    // Method to perform quicksort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partitioning index
            int pivotIndex = partition(array, low, high);
            
            // Recursively sort elements before partition and after partition
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Method to partition the array
    private static int partition(int[] array, int low, int high) {
        // Choose the rightmost element as the pivot
        int pivot = array[high];
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] and array[j]
                swap(array, i, j);
            }
        }
        // Swap the pivot element with the element at i + 1
        swap(array, i + 1, high);
        return i + 1; // Return the partition index
    }

    // Method to swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Main method to test quicksort
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10}; // Example array
        System.out.println("Original array: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1); // Sort the array

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
