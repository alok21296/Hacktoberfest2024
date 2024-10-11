import java.util.Arrays;

public class HeapSort {

    // Method to perform heap sort
    public static void heapSort(int[] array) {
        int n = array.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract elements from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move the current root (maximum) to the end
            swap(array, 0, i);

            // Call heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    // Method to heapify a subtree rooted at index i
    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child index
        int right = 2 * i + 2; // right child index

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(array, i, largest); // Swap root with largest

            // Recursively heapify the affected subtree
            heapify(array, n, largest);
        }
    }

    // Method to swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Main method to test heap sort
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10}; // Example array
        System.out.println("Original array: " + Arrays.toString(array));

        heapSort(array); // Sort the array

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
