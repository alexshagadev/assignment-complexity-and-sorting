package utilities;
import java.util.Comparator;

public class InsertionSort {

    /*
     * The sort method takes in an integer array.
     * It iterates through the array, and for each element, it places it in the correct position
     * relative to the already sorted portion of the array to the left.
     */
    
    public <T extends Comparable<? super T>> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T current = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than the key, to one position ahead
            // of their current position.
            while (j >= 0 && array[j].compareTo(current) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
    
    
    public static <T> void sort(T[] array, Comparator<T> comparator) {
        for (int i = 1; i < array.length; i++) {
            T current = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than the key, to one position ahead
            // of their current position based on the comparator.
            while (j >= 0 && comparator.compare(array[j], current) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
}



