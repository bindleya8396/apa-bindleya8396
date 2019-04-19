//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays; 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 2;
 
		while (number / 10 >= 10) {
			number = number / 10;
			count ++;
		}
		return count;
	}

	public static int[] getSortedDigitArray(int number)
	{
		int count = getNumDigits(number);

		int[] sorted = new int[count];

		for (int i = 0; i < count; i++) {
			sorted[i] = number % 10;
			number = number / 10;
		}

		Arrays.sort(sorted);

		return sorted;
	}
}
