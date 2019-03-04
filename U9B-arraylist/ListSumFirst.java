//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.List;
import java.util.ArrayList;

public class ListSumFirst
{
  public static int go(List<Integer> ray)
  {
	int counter = 0;

	for(int i = 1; i < ray.size(); i++) {
		if (ray.get(i) > ray.get(0)) {
			counter += ray.get(i);
		} 
	}

	if (counter == 0) {
		counter = -1;
	}

    return counter;
  }
}
