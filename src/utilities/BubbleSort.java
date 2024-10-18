package utilities;

public class BubbleSort
{
	public static <T extends Comparable<? super T>> void bubble(T[] array )
	{
		int len = array.length;
		
		// If the array has one or less objects, then the array will return.
		if (len < 2)
		{
			return;
		}

		//The bubble sort is implemented.
		// i represents the length of the un-sorted array
		for (int i = 0; i < (len -1); i++)
		{
			//switched is used as a flag indicating
			//if elements at array[j] and array[j+1] are switched.
			boolean switched = false;
			// j represents the objects potentially being switched.
			for (int j = 0; j < (len - 1 - i); j++ )
			{
				if (array[j].compareTo(array[j+1]) > 0)
				{
					T held = array[j];
					array[j] = array[j + 1];
					array[j + 1] = held;
					switched = true;
				}
			}
			
			//if elements at array[j] and array[j+1] are not switched,
			//the for loop incrementing i will be repeated.
			if (switched == false)
			{
				break;
			}
		}		
	}
}