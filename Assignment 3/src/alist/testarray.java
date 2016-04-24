package alist;

/*Michael Tobias
 *Assignment 3 - testarry.java
 *CSC 3410 - J.L. Bhola
 *Fall 2015
 *
 *test cases to prove methods in Arraylist.java work
 */

public class testarray  //begin
{
	public static void main(String[] args) //main
	{
		Arraylist list = new Arraylist();
		list.isEmpty(); //shows array is empty
		list.add(1); //adds 1 at position 0
		list.printArray(); //prints current array
        list.add(2); //adds 2 at position 1
        list.printArray(); //prints current array
        list.add(3); //adds 3 at position 2
        list.printArray(); //prints current array
        list.add(4); //adds 4 at position 4
        list.printArray(); //prints current array
        list.add(5); //adds 5 at position 4
        list.printArray(); //prints current array
        list.add(6); //adds 6 at position 5
        list.printArray(); //prints current array
        list.add(7); //adds 7 at position 6
        list.printArray(); //prints current array
        list.add(8,"test"); //adds test at position 7
        list.printArray(); //prints current array
        list.add(9); //adds 9 at position 8
        list.printArray(); //prints current array
        list.add(10); //adds 10 at position 9
        list.printArray(); //prints current array
        list.add(11,"test2"); //adds test2 at position 10
        list.printArray(); //prints current array
        list.add(12); //adds 12 at position 11
        list.printArray(); //prints current array
        list.get(10); //prints 10 which is in position 9
        list.size(); //prints size of array
        list.isEmpty(); //checks if empty. since full not it prints its not empty
        list.isIn("test"); //is in array
        list.isIn("test2"); //is in array
        list.isIn("mike"); //is not in array
        list.isIn(1); //is in array
        list.find("test"); //prints test since its in the array at position 8
        list.find("mike"); //does not exist since its not in the array
        list.find(1); //is in array
        list.printArray(); //prints current array
        list.remove("test2"); //removes test2 from the array
        list.printArray(); //prints current array
        list.remove("mike"); //doesn't remove since mike isn't in the array
        list.remove(1); //removes 1
        list.printArray(); //prints current array
	}
} //end
