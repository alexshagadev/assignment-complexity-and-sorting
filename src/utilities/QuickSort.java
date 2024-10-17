package utilities;
import java.util.Comparator;

public class QuickSort {
	
	/*
	 * Partitions the provided array into two halves at the defined pivot element,
	 * Any elements smaller than the pivot are moved to the left.
	 * Elements larger than the pivot are moved to the right
	 * 
	 * @param array to partition
	 * @param low Starting index
	 * @param high Ending index
	 * @param comparator Comparator used to compare elements, defined in AppDriver.java
	 * @return Index of the pivot after partition
	 */	
	private static <T extends Comparable<? super T>> int partition(T[] array, int low, int high, Comparator<T> comparator) {
		T pivot = array[high]; // Pivot starts as last element in array
		int i = low - 1; // Smaller element index
		for (int j = low; j < high; j++) {
			if(comparator.compare(array[j], pivot) <= 0) {
				i++;
				swap(array, i, j); // Swap smaller element with current
			}
		}
		swap(array, i + 1, high); // Moves Pivot to correct position
		return i + 1;
	}
	
	/*
	 * Swaps two elements in an array of any object
	 * 
	 * @param array Where elements are swapped
	 * @param i Index of first element
	 * @param j Index of second element
	 */	
	private static <T extends Comparable<? super T>> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/*
	 * Sorts the array using the quicksort algorithm
	 * 
	 * @param array To be sorted
	 * @param low Starting index
	 * @param high Ending index
	 * @param comparator Comparator used to compare objects
	 */
	private static <T extends Comparable<? super T>> void quickSort(T[] array, int low, int high, Comparator<T> comparator) {
		if (low < high) {
			int partitionIndex = partition(array, low, high, comparator); // Finds index from partition
			quickSort(array, low, partitionIndex - 1, comparator); // Recursively sorts elements before and after partition
			quickSort(array, partitionIndex + 1, high, comparator);
		}
	}
	
	/*
	 * Public function to be called out of class, begins quicksort process with array
	 * 
	 * @param array To be sorted
	 * @param comparator Comparator used to compare objects
	 */
	public static <T extends Comparable<? super T>> void sort(T[] array, Comparator<T> comparator) {
		quickSort(array, 0, array.length - 1, comparator);
	}
}