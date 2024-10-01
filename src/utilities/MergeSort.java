package utilities;

public class MergeSort {
	
	/*
	 * The sort method takes in an integer array.
	 * It's responsible for halving the array down to individual elements recursively. 
	 * It finds the middle, creates two empty halves, fills them in with the original elements, and then repeats
	 * the process with those sub arrays. This repeats until the array is split down into individual elements.
	 */
	public void sort(int[] array) {
		// If the sub array is made up of one element, the splitting is done. 
        if (array.length < 2) {
            return; 
        }
        
        int mid = array.length / 2; // Find middle
        // Initialize left and right sub arrays
        int[] left = new int[mid]; // Left half
        int[] right = new int[array.length - mid]; // Right half 
        
        // Fill the left sub-array
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        
        // Fill the right sub-array
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }
        
        // Repeat the process recursively until the first check lights up
        sort(left);
        sort(right);
        
        // Once the array is split correctly, merge it back up.
        // At this point, array = original array, left & right = individual elements from splitting.
        merge(array, left, right);
    }

	/*
	 * The merge function takes in the original array and also the left/right halves.
	 * It then merges those left/right halves, adding the smallest elements back in the main array one by one.
	 */
    private void merge(int[] array, int[] left, int[] right) {
        int i = 0; // left
        int j = 0; // right
        int k = 0; // main array
        
        // Merge the left and right arrays. The smallest element is added back into the main array.
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++]; // Add smaller element to main array
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
}
