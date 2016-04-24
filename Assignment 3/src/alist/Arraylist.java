package alist;

/*Michael Tobias
 *Assignment 3 - Araraylist.java
 *CSC 3410 - J.L. Bhola
 *Fall 2015
 *
 *The goal of this assignment is to get experience implementing array list ADT without using the array list library.
 *This is accomplished by initiating an array that acts as array list ADT. In this program, I use 10 required methods: 
 *Arraylist() - default constructor, Arraylist(int) - constructor with parameter type, 
 *add(Object) - adds input to first available position, add(int, Object) - adds object at requested position, 
 *get(int) - retrieves what is at requested position, size() - prints size of the array at time of calling counting
 *elements only, 
 *isEmpty() - checks if array is empty, isIn(Object) - checks if requested object is in array, 
 *find(Object) - checks if object is in array and returns its position, and remove(Object) - checks if object is in array
 *and removes if it exist. 
 *I also used two extra methods; increaseSize(int) - doubles array size in order to make room for more elements
 *and printArray() - prints entire array at time of calling. These methods are then tested using testarray.java in order
 *to prove each one works as described. All methods are in one class (Arraylist). 
 *
 *
 */

import java.util.Arrays;

public class Arraylist  //begin
{
	Object[] store; //array
	int asize = 0; //array size
	int acap; //array capacity
	
	Arraylist() //default constructor
	{
		acap = 10; //constructor size is set at 10
		store = new Object[acap]; //new array list
	}
	
	public Arraylist(int n) //accepts integer parameter type and sets capacity
	{
		acap = n;
		store = new Object[n];
	}
	
	private void increaseSize(int size) //doubles array size if array size grows to 10.
	{
		if (size >= store.length) //checks array size. if true then double size. if not, size remains 10
		{
			store = Arrays.copyOf(store, store.length * 2); //doubles array length by 2
			acap = acap * 2;
			System.out.println("Array size has been increased to " + acap); //output
		}
	 }
	
	public void add(Object x) //adds value at the first free position of the array list
	{
		int asize2 = asize;
		increaseSize(asize+1); //checks array size
        store[asize] = x; //adds input at first free position
        asize++;
        System.out.println(x + " has been added at position " + asize2); //output
    }
	
	public void add(int index, Object x) //adds an object at designated integer position
	{	int size3 = index-1;
		increaseSize(asize+1); //checks array size
        store[index-1] = x; //stores at one less the integer value because array counts from 0
        asize++;
        System.out.println(x + " has been added at position " + size3); //output
    }
	
	 public Object get(int index) //retrieves value at given location
	 {
		 int position = index-1;
		 if (index < asize) //checks if value position is in array
		 {
			 System.out.println("" + index + " is in the array at position " 
		 + position  + "\n"); //output
			 return store[index]; //return
		 } 
		 else 
		 {
			 throw new ArrayIndexOutOfBoundsException(); //exception if value doesn't exist at position
		 }
	 }
	
	 public int size() //prints size of array. doesn't count null positions, just ones that are filled
	 {
		 System.out.println("The number of elements in the array is " + asize + "\n"); //output
		 return asize; //return
	 }
	 
	 public boolean isEmpty() //checks if array is empty (no elements)
	 {
	        if (asize == 0) //if empty
	        {
	        	System.out.println("Array is empty.\n"); //output
	        	return true; //return
	        } 
	        else //if not empty
	        {
	        	System.out.println("Array is not empty.\n"); //output
	            return false; //return
	        }
	 }
	 
	 public boolean isIn(Object obj) //checks if object is in the array
	 {
	        boolean isIn = false; //boolean check
	        for (int i =0; i < asize; i++)  //searches array
	        {
	            if (store[i].equals(obj)) //if found
	            {
	                System.out.println(obj + " exists in the array.\n"); //output
	                isIn = true;
	                break;
	            } 
	        }
	        if (isIn==false)  //if not found
	        {
	                System.out.println(obj + " does not exist in the array.\n"); //output
	        }
	        return isIn; //return
	 }

	 public int find(Object n) //finds where object is in the array
	 {
		 boolean isIn = false; //boolean checker
		 int temp = -1;
		 for (int i = 0; i < asize; i++)  //searches array
		 {
			 if (store[i].equals(n)) //if in array
			 {
				 System.out.println(n + " is at position " + (i) + "\n"); //output
				 temp = i;
				 isIn = true;
				 break;
			 }        
		 }
		 if(isIn==false) //if not in array
		 {
			 System.out.println(n + " does not exist.\n"); //output
			 temp = -1;
		 }   
		 return temp;
	 }
	 
	 public void remove(Object n) //removes object in array
	 {
		 if (isIn(n)) //checks if the object is in the array first
		 {
			 int position = find(n); //uses find method to locate the object
			 for (int i = position; i < asize; i++) //searches array
			 {
				 store[i] = store[i + 1]; //points to object
			 }
			 store[asize - 1] = null; //removes from array
			 asize--; //decreases array size
			 System.out.println(n + " has been removed from the array\n"); //output
		 } 
		 else //if not in array
		 {
			 System.out.println(n +  " cannot be removed because it does not exist\n"); //output
		 }
	 }
	 
	 void printArray() //prints current array
	 {
		 for (Object storetemp : store) 
		 {
			 System.out.print(storetemp + " "); //output
		 }
		 System.out.println("\n");
	 }
}//end
