package dir;

/*Michael Tobias
 *Assignment 4 - phonedirenode.java
 *CSC 3410 - J.L. Bhola
 *Fall 2015
 *
 *This class creates the nodes that tie each new linked list entry together. It its responsible for getting, setting,
 *and retrieving data thus allowing phonedirlist and phonedir to work.
 */

public class phonedirnode //begin
{
	private String firstName; //first name
	private String lastName; //last name
	private String phoneNumber; //phone number
	private String name; // name
	private phonedirnode next; //next
	private phonedirnode prev; //previous
	
	public phonedirnode() //constructor
	{	
	}
	
	public phonedirnode(String firstname, String lastname, String phonenumber) //creates node
	{
		this.firstName = firstname;
		this.lastName = lastname;
		this.phoneNumber = phonenumber;
		name = firstName + " " + lastName;
		next = null;
	}
	
	public void setData(String firstname, String lastname, String phonenumber) // sets record (fn, ln, pn)
	{
		this.firstName = firstname;
		this.lastName = lastname;
		this.phoneNumber = phonenumber;
		name = firstName + " " + lastName;
	}
	
	public String getFirstName() //gets first name
	{
		return firstName;
	}
	
	public String getLastName() //gets last name
	{
		return lastName;
	}
	
	public String getPhoneNumber() //gets phone number 
	{
		return phoneNumber;
	}
	
	public void setNext(phonedirnode pdn) //sets next
	{
		next = pdn;
	}
	
	public void setPrev(phonedirnode pdn) //sets previous
	{
		prev = pdn;
	}
	
	public void setFirstName(String fn) //sets first name
	{
		firstName = fn;
	}
	
	public void setLastName(String ln) //sets last name
	{
		lastName = ln;
	}
	
	public void setPhone(String phone) //sets phone number
	{
		phoneNumber = phone;
	}
	
	public phonedirnode getNext() //getter for next
	{
		return next;
	}
	
	public phonedirnode getPrev() //getter for previous
	{
		return prev;
	}
	
	public String getName() //gets first and last name
	{
		return firstName + " " + lastName;
	}
	
	public String toString() //returns name (first and last) plus phone number
	{
		return name + " " + phoneNumber;
	}
	
	public String specialString() //returns first name, last name, and phone number when printing all records
	{
		return " " + firstName + "                       " + lastName + "                     " + phoneNumber;
	}
}//end
