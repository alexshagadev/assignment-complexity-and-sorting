package utilities;
import java.util.Comparator;

public class SelectionSort {

    /*
     * The sort method takes in an integer array.
     * It iterates through the array and selects the largest element from the unsorted portion
     * of the array to swap it with the first element in the unsorted portion. 
     */
	public <T extends Comparable<? super T>> void sort(T[] array) {
        int n = array.length;

        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i; // Assume the current element is the maximum

            // Find the index of the maximum element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[maxIndex]) > 0) {
                	maxIndex = j; // Update minIndex if a larger element is found
                }
            }

            // Swap the found maximum element with the first unsorted element
            if (maxIndex != i) {
                T temp = array[maxIndex];
                array[maxIndex] = array[i];
                array[i] = temp;
            }
        }
    }
	
	public static <T> void sort(T[] array, Comparator<T> comparator) {
        int n = array.length;

        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i; // Assume the current element is the maximum

            // Find the index of the maximum element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (comparator == null) {
                    @SuppressWarnings("unchecked")
                    Comparable<T> currentElement = (Comparable<T>) array[j];
                    if (currentElement.compareTo(array[maxIndex]) > 0) {
                    	maxIndex = j; // Update minIndex if a larger element is found
                    }
                } else {
                    // Use the provided comparator to compare elements
                    if (comparator.compare(array[j], array[maxIndex]) > 0) {
                    	maxIndex = j; // Update maxIndex if a larger element is found
                    }
                }
            }

            // Swap the found maximum element with the first unsorted element
            if (maxIndex != i) {
                T temp = array[maxIndex];
                array[maxIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}
