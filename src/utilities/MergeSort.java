package utilities;

import java.util.Comparator;

public class MergeSort {

    /*
     * The sort method takes in an array of objects that implement Comparable.
     * It's responsible for halving the array down to individual elements recursively. 
     * It finds the middle, creates two empty halves, fills them in with the original elements, and then repeats
     * the process with those sub arrays. This repeats until the array is split down into individual elements.
     */
    public <T extends Comparable<? super T>> void sort(T[] array) {
        // If the sub array is made up of one element or less, the splitting is done.
        if (array.length < 2) {
            return;
        }

        int mid = array.length / 2; // Find the middle

        @SuppressWarnings("unchecked")
        T[] left = (T[]) new Comparable[mid]; // left
        @SuppressWarnings("unchecked")
        T[] right = (T[]) new Comparable[array.length - mid]; // right

        // Fill the left sub-array
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        // Fill the right sub-array
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        // Repeat until the first check succeeds
        sort(left);
        sort(right);

        // Once the array is split correctly, merge it back up.
        merge(array, left, right);
    }

    /*
     * The merge function takes in the original array and also the left and right halves
     * It then merges those sections, adding the largest elements back into the main array one by one.
     */
    private <T extends Comparable<? super T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0;
        int j = 0;
        int k = 0; 

        // Merge the left and right arrays. The largest element is added back into the main array.
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) > 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy left elements
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy right elements
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Sort but for comparator
    public static <T> void sort(T[] array, Comparator<T> comparator) {
        // If the sub array is made up of one element the splitting is done.
        if (array.length < 2) {
            return;
        }

        int mid = array.length / 2;

        @SuppressWarnings("unchecked")
        T[] left = (T[]) new Object[mid]; 
        @SuppressWarnings("unchecked")
        T[] right = (T[]) new Object[array.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }
        
        sort(left, comparator);
        sort(right, comparator);
        
        merge(array, left, right, comparator);
    }
    
    // Merge but for comparator
    @SuppressWarnings("unchecked")
    private static <T> void merge(T[] array, T[] left, T[] right, Comparator<T> comparator) {
        int i = 0;
        int j = 0; 
        int k = 0; 

        while (i < left.length && j < right.length) {
            if (comparator == null) {
                // natural order
                if (((Comparable<T>) left[i]).compareTo(right[j]) > 0) {
                    array[k++] = left[i++];
                } else {
                    array[k++] = right[j++];
                }
            } else {
                // comparator
                if (comparator.compare(left[i], right[j]) > 0) {
                    array[k++] = left[i++];
                } else {
                    array[k++] = right[j++];
                }
            }
        }

        // Copy left elements
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy right elements
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
