package utilities;

public class SelectionSort {

    /*
     * The sort method takes in an integer array.
     * It iterates through the array and selects the smallest element from the unsorted portion
     * of the array to swap it with the first element in the unsorted portion. 
     */
    public void sort(int[] array) {        
        // Iterate through the entire array
        for (int i = 0; i < array.length - 1; i++) {
            int minNumber = i;

            // Find the minimum element in the unsorted portion of the array
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minNumber]) {
                	minNumber = j; // Update the index of the smallest element found
                }
            }

            // Swap the found minimum element with the first unsorted element
            if (minNumber != i) {
                int temp = array[minNumber];
                array[minNumber] = array[i];
                array[i] = temp;
            }
        }
    }
}
