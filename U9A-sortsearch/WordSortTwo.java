//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence)
	{
		wordRay = sentence;
	}

	public void sort()
	{
		String[] words = wordRay.split("");

		Arrays.sort(words);
	}

	public String toString()
	{
		String output="";
		sort();
		for (int i = 0; i < words.length; i++) {
			output += words[i] + "\n";

		return output;
		}
	}
}
