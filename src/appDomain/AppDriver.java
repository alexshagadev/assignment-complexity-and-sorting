package appDomain;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AppDriver
{

	public static void main( String[] args )
	{
		// TODO Auto-generated method stub
		
		File shapes1 = new File("./res/shapes1.txt");
		Scanner s1 = null;
		
		try
		{
			s1 = new Scanner(shapes1);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		System.out.println("Here is the unsorted list of " + s1.next() + " shapes:");
		
		while( s1.hasNext() )
		{
			String name = s1.next();
			System.out.println( name );

			String height = s1.next();
			System.out.println( height );

			String side = s1.next();
			System.out.println( side );
		}

		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

	}

}
