package dir;

/*Michael Tobias
 *Assignment 4 - phonedir.java
 *CSC 3410 - J.L. Bhola
 *Fall 2015
 *
 *The goal of this assignment is to get experience implementing linked list to manage a phone number directory. This is
 *accomplished by creating 3 linked list: one for the first name one for the last name, and one for the phone number of
 *the record. The program uses a main menu controlled by a switch to initiate a method. the menu options include:
 *a: show all records (shows all records currently created), d: delete current (deletes current record),
 *f: change first name of current (changes first name of current record), l: change last name of current record 
 *(changes last name of current record), n: add new record (adds new record), p: change phone number of current record 
 *(changes phone number of current record), q: quit (exits program), and s: select a new record (changes current record)
 *
 */

import java.util.*;

public class phonedir 
{	
	public static void main(String[] args) //main
	{
		boolean quit = false; //boolean checker
		LinkedList<String> first = new LinkedList<String>(); //linked list for first name
		LinkedList<String> last = new LinkedList<String>(); //linked list for last name
		LinkedList<String> phonenumber = new LinkedList<String>(); //linked list for phone number
		Scanner scan = new Scanner(System.in); //new scanner
		
		while (!quit) 
		{
			//main menu
			System.out.println("\na: Show all records");
			System.out.println("d: Delete the current record");
			System.out.println("f: Change the first name in current record");
			System.out.println("l: Change the last name in current record");
			System.out.println("n: Add a new record");
			System.out.println("p: Change the phone number in the current record");
			System.out.println("q: Quit");
			System.out.println("s: Select a record from the list to become current record\n");
			
			System.out.println("Enter a command from the list above (q to quit):\n");
			String menu;
			menu = scan.next(); //user input
			char pick = menu.charAt(0); //initiates switch
			
			switch (pick) //switch
			{
				case 'a' : //all record
					phonedirlist list = new phonedirlist(); //creates new list
					for (int i = 0; i < first.size(); i++ ) 
					{
						phonedirnode node = new phonedirnode(); //new node
						node.setData(first.get(i), last.get(i), phonenumber.get(i)); //sets record
						list.insert2(node); //inserts
					}
					list.print(); //prints list
					break; //break
						
				case 'n' : //new record
					System.out.println("\nEnter first name: ");
					String first1 = scan.next();
					System.out.println("\nEnter last name: ");
					String last1 = scan.next();
					System.out.println("\nEnter phone number in the following format -> XXX-XXX-XXXX :");
					String number = scan.next();
					first.add(first1); //adds to first name linked list
					last.add(last1); //adds to last name linked list
					phonenumber.add(number); //adds to phone number linked list
					System.out.println("\nCurrent record is: " + first1 + " " + last1 + " " + number); //output
					break; //break
						
				case 'd' : //delete
					System.out.println("Removed: " + first.getLast() + " " + last.getLast() + " " + phonenumber.getLast()); //output
					first.removeLast(); //removes current from first name linked list
					last.removeLast(); //removes current from last name linked list
					phonenumber.removeLast(); //removes current from phone number linked list
					break; //break
						
				case 'f' : //change first name of current
					try 
					{
						String change;
						System.out.println("\nEnter new first name:");
						change = scan.next();
						int findLast = first.lastIndexOf(first.getLast()); //uses current record
						first.set(findLast, change); //replaces original first name with new name input
						System.out.println("\nCurrent record is: " + first.getLast() + " " + last.getLast() + " " + phonenumber.getLast()); //output
					} 
					
					catch (NoSuchElementException ex) //exception
					{
						//executes exception
						System.out.println("\nNo current record");
					}
						break; //break
						
				case 'l' : //change last name
					String change1;
					System.out.println("\nEnter new last name:");
					change1 = scan.next();
					int findLast1 = last.lastIndexOf(last.getLast()); //uses current record
					last.set(findLast1, change1); //replaces original last name with new name input
					System.out.println("\nCurrent record is: " + first.getLast() + " " + last.getLast() + " " + phonenumber.getLast()); //output
					break; //break
						
				case 'p' : //change phone number
					String change2;
					System.out.println("\nEnter new phone number:");
					change2 = scan.next();
					int findLast2 = phonenumber.lastIndexOf(phonenumber.getLast()); //uses current
					phonenumber.set(findLast2, change2); //replaces original phone number with new number input
					System.out.println("\nCurrent record is: " + first.getLast() + " " + last.getLast() + " " + phonenumber.getLast()); //output
					break; //break
						
				case 's' : //select a new current record
					String search1;
					String search2;
					System.out.println("\nEnter first name:");
					search1 = scan.next();
					System.out.println("\nEnter last name:");
					search2 = scan.next();
					if(last.contains(search2) != true) //checks if record exist
					{
						System.out.println("\nRecord Does Not Exist");
						break;
					} 
					
					else 
					{
						int indexfirst = first.indexOf(search1); //sets index to first name input
						first.addLast(first.get(indexfirst)); //adds to current
						first.remove(indexfirst); //removes index
						int indexlast = last.indexOf(search2); //sets index to last name input
						last.addLast(last.get(indexlast)); //adds to current
						last.remove(indexlast); //removes index
						phonenumber.addLast(phonenumber.get(indexfirst)); //sets index to phone number of index
						phonenumber.remove(indexfirst); //removes index
						System.out.println("\nCurrent record is: " + first.getLast() + " " + last.getLast() + " " + phonenumber.getLast()); //output
						break; //break
					}
						
				case 'q' : //quit
					System.out.println("\nProgram Terminiated"); //output
					System.exit(0); //exit
					break; //break
						
				default: //invalid command
					System.out.println("\nEntry isn't a vaild command"); //output
			}
		}
	}
}//end