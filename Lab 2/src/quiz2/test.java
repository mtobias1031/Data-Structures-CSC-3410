package quiz2;

public class test
{
	
	public static void main(String[] args) 
	{
		linkedlist list = new linkedlist();

		list.add("3");
		list.add("10");
		list.add("22");
		list.add("31");
		list.add("39");
		list.add("41");
		list.add("58");
		list.add("66");


		System.out.println("\nall values in linked list: " + list + "\n");
		list.size();
		
	    System.out.println("the 1st element is: " + list.get(1));
	    System.out.println("the 2nd element is: " + list.get(2));
	    System.out.println("the 3rd element is: " + list.get(3));
	    System.out.println("the 4th element is: " + list.get(4));
	    System.out.println("the 5th element is: " + list.get(5));
	    System.out.println("the 6th element is: " + list.get(6));
	    System.out.println("the 7th element is: " + list.get(7));
	    System.out.println("the 8th element is: " + list.get(8));
	}
}