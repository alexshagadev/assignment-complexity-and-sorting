package utilities;

public class BubbleSort
{
	public void sort(Float[] array)
	{
		int len = array.length;
			
		for (int i = 0; i < (len -1); i++)
		{
			for (int j = 0; j < (len - 1 - i); j++ )
			{
				if (array[j] > array[j+1])
				{
					float held = array[j];
					array[j] = array[j + 1];
					array[j + 1] = held;
				}
			}
		}		
	}
}