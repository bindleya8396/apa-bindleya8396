//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class SumFirstRunner
{
  public static void main( String args[] )
  {
	ArrayList<Integer> nums = new ArrayList<Integer>();

	nums.add(-99);
	nums.add(1);
	nums.add(2);
	nums.add(3);
	nums.add(4);
	nums.add(5);
	nums.add(6);
	nums.add(7);
	nums.add(8);
	nums.add(9);
	nums.add(10);
	nums.add(5);

	ListSumFirst first = new ListSumFirst();
	System.out.println(first.go(nums));
  }

}
