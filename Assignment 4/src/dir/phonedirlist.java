package dir;

/*Michael Tobias
 *Assignment 4 - phonedirlist.java
 *CSC 3410 - J.L. Bhola
 *Fall 2015
 *
 *This class contains the methods that build, set, and get records. It uses the phonedirnode class to help
 *find records. In this class is the constructor, empty checker, insertion methods, removal method, change methods,
 *get methods, and print method.
 */

import java.util.*;

public class phonedirlist extends LinkedList<String> //extends linked list from phonedir.java
{

	private static final long serialVersionUID = 1L; //serialID
	private phonedirnode head; //starts node
	
	public phonedirlist() //constructor
	{
		head = null;
	}
	
	public boolean isEmpty() //is empty checker
	{
		return head == null;
	}
	
	public phonedirnode findInsertionPoint(phonedirnode head, phonedirnode node) //find insertion point method
	{
		if (head == null || node.getLastName().compareTo(head.getLastName()) < 0)
			return null;
		phonedirnode curr = head;
		while (curr != null) 
		{
			if (curr.getLastName().compareTo(node.getLastName()) == 0)
				return curr;
			else if(curr.getNext() == null || curr.getNext().getLastName().compareTo(node.getLastName()) > 0)
				return curr;
			else 
				curr = curr.getNext();
		}
		return null;
	}
	
	public void insert2(phonedirnode node) //insert 2 method
	{
		phonedirnode newNode = node;
		phonedirnode insertPoint = this.findInsertionPoint(this.head, node);
		if (insertPoint == null)
		{
			newNode.setNext(this.head);
			this.head = newNode;
		}
		else 
		{
			if (insertPoint.getLastName().compareTo(node.getLastName()) == 0) 
			{
				insertPoint.setNext(insertPoint.getNext());
			} 
			else
				newNode.setNext(insertPoint.getNext());
				insertPoint.setNext(newNode);
		}
	}
	
	public void insert(phonedirnode newNode) //insert method
	{
		if (isEmpty())
			head = newNode;
		else 
		{
			phonedirnode current = head;
			while(current.getNext() != null)
				current = current.getNext();
			current.setNext(newNode);
		}
	}
	
	public void insertAtFront(phonedirnode newNode) //inserts at front method
	{
		newNode.setNext(head);
		head = newNode;
	}
	
	public String remove(String name) //remove current method
	{
		if (isEmpty())
			return "Phone directory is empty.";
		phonedirnode current = head;
		phonedirnode previous = null;
		if (current.getName().equals(name)) 
		{
			head = current.getNext();
			return "Removed " + current.toString();
		}
		while ((current.getNext() != null) && (!current.getName().equals(name))) 
		{
			previous = current;
			current = current.getNext();
		}
		if (current.getName().equals(name)) 
		{
			previous.setNext(current.getNext());
			return "Removed " + current.toString();
		} 
		else
			return ("Sorry. No entry for " + name);
	}
	
	
	public void changeFirstName(String change) //change first name method
	{
		if (isEmpty()) 
			System.out.println("No current record");
		else 
		{
		head.setData(change, head.getLastName(), head.getPhoneNumber());
		System.out.println("Current record is: " + head.toString());
		}
	}
	
	public void changeLastName(String change) //change last name method
	{
		if (isEmpty())
			System.out.println("No current record");
		else 
		{
		head.setData(head.getFirstName(), change, head.getPhoneNumber());
		System.out.println("Current record is: " + head.toString());
		}
	}
	
	public void changePhone(String change) //change phone number method
	{
		if (isEmpty())
			System.out.println("No current record");
		else 
		{
		head.setData(head.getFirstName(), head.getLastName(), change);
		System.out.println("Current record is: " + head.toString());
		}
	}
	
	public String getCurrentName() //current record
	{
		phonedirnode current = head;
		return current.getName();
	}
	
	public String search(String firstName, String lastName) //search method
	{
		if(isEmpty())
			return "Phone directory is empty";
		else 
		{
			phonedirnode current = head;
			while (current.getNext() != null && (!current.getFirstName().equals(firstName)) && (!current.getLastName().equals(lastName)))
				current = current.getNext();
			if (current.getFirstName().equals(firstName) && current.getLastName().equals(lastName))
			{
				head = current;
				return "Current record is " + head.toString();
				}
			else
				return "No matching record found.";
			}
		}
	
	public void print() //print method
	{
		phonedirnode current = head;
		System.out.println("\n  First Name                Last Name               Phone Number");
		System.out.println("-------------             -------------             -------------");
		while (current != null) 
		{
			System.out.println(current.specialString());
			current = current.getNext();
		}
	}
}
