//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifterRunner
{
	public static void main( String args[] ) throws IOException
	{
		//add test cases
		Scanner prompt = new Scanner(System.in);
		System.out.print("Enter the size of the list: ");
		int n = prompt.nextInt();

		NumberShifter nums = new NumberShifter();
		int[] array = nums.makeLucky7Array(n);
		System.out.println(Arrays.toString(array));
		nums.shiftEm(array);
		System.out.println(Arrays.toString(array));
	}
}



