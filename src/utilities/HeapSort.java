package utilities;
import java.util.Comparator;

public class HeapSort {
	
	/*
	 * Builds a max heap from an array of any objects. The heap ensures no parent nodes are greater than their child nodes
	 * 
	 * @param array To be heapified
	 * @param size The size of the heap
	 * @param root The root of the subtree
	 * @param comparator Comparator used to compare objects
	 */
	private static <T extends Comparable<? super T>> void heapify(T[] array, int size, int root, Comparator<T> comparator) {
		int largest = root;
		int l = 2 * root + 1; // Left Child
		int r = 2 * root + 2; // Right Child
		
		// If l > largest, l = largest
		if (l < size && comparator.compare(array[l], array[largest]) > 0) {
			largest = l;
		}
		
		// If r > largest, r = largest
		if (r < size && comparator.compare(array[r], array[largest]) > 0) {
			largest = r;
		}
		
		// If largest != root, heapify subtree
		if (largest != root) {
			T temp = array[root];
			array[root] = array[largest];
			array[largest] = temp;
			heapify(array, size, largest, comparator); // Recursively heapify subtree
		}
	}
	
	/*
	 * Sorts the given array using the heap sort algorithm
	 * 
	 * @param array To be sorted
	 * @param comparator Comparator used to compare objects
	 */
	private static <T extends Comparable<? super T>> void heapSort(T[] array, Comparator<T> comparator) {
		int size = array.length;
		
		// Build max heap
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(array, size, i, comparator);
		}
		
		// Extract each element one by one
		for (int i = size - 1; i > 0; i--) {
			T temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapify(array, i, 0, comparator);
		}
	}
	
	/*
	 * Public function to be called outside the class, starts the heap sort process.
	 * 
	 * @param array To be sorted
	 * @param comparator Comparator used to compare objects
	 */
	public static <T extends Comparable<? super T>> void sort(T[] array, Comparator<T> comparator) {
		heapSort(array, comparator);
	}
	
	
}
