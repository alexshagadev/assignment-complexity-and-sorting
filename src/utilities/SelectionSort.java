package utilities;
import java.util.Comparator;

public class SelectionSort {

    /*
     * The sort method takes in an integer array.
     * It iterates through the array and selects the smallest element from the unsorted portion
     * of the array to swap it with the first element in the unsorted portion. 
     */
	public <T extends Comparable<? super T>> void sort(T[] array) {
        int n = array.length;

        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the current element is the minimum

            // Find the index of the minimum element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }

            // Swap the found minimum element with the first unsorted element
            if (minIndex != i) {
                T temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }
	
	public static <T> void sort(T[] array, Comparator<T> comparator) {
        int n = array.length;

        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the current element is the minimum

            // Find the index of the minimum element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (comparator == null) {
                    // Use natural ordering if comparator is not provided
                    @SuppressWarnings("unchecked")
                    Comparable<T> currentElement = (Comparable<T>) array[j];
                    if (currentElement.compareTo(array[minIndex]) < 0) {
                        minIndex = j; // Update minIndex if a smaller element is found
                    }
                } else {
                    // Use the provided comparator to compare elements
                    if (comparator.compare(array[j], array[minIndex]) < 0) {
                        minIndex = j; // Update minIndex if a smaller element is found
                    }
                }
            }

            // Swap the found minimum element with the first unsorted element
            if (minIndex != i) {
                T temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}
