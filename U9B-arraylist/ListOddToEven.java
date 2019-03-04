//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
  public static boolean go( List<Integer> ray )
  {
	firstOdd = 0;
	firstEven = 0;
	for( int i = 0; i < ray.size(); i++) {
		if (ray.get(i) % 2 !=0) {
			firstOdd = ray.get(i);
			for ( int j = i; j < ray.size(); j++) {
				if (ray.get(j) % 2) {
					firstEven = ray.get(j);


    return false;
  }
}
