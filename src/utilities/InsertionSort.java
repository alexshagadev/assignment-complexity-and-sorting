package utilities;

public class InsertionSort {

    /*
     * The sort method takes in an integer array.
     * It iterates through the array, and for each element, it places it in the correct position
     * relative to the already sorted portion of the array to the left.
     */
    public void sort(int[] array) {        
        // Iterate from the second element to the end of the array.
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            
            // Move elements of the sorted portion that are greater than 'key' to one position ahead.
            while (j >= 0 && array[j] > current) {
            	array[j + 1] = array[j]; // Shift element to the right
                j--;
            }
            
            // Insert the key element in its correct position in the sorted portion
            array[j + 1] = current;
        }
    }
}
