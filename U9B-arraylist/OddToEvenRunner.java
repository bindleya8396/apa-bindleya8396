//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class OddToEvenRunner
{
  public static void main( String args[] )
  {
	ListOddToEven num = new ListOddToEven();

	List<Integer> myList = new ArrayList<Integer>();
	myList.add(7);
	myList.add(1);
	myList.add(5);
	myList.add(3);
	myList.add(11);
	myList.add(5);
	myList.add(6);
	myList.add(7);
	myList.add(8);
	myList.add(9);
	myList.add(10);
	myList.add(12345);
	myList.add(11);

	System.out.println(num.go(myList));
  }
}
