/*Michael Tobias
 *Assignment 1 - Card.java
 *CSC 3410 - J.L. Bhola
 *Fall 2015
 */

package cardgame;

import java.util.*;
@SuppressWarnings("unused")

public class Card 
{	
	private int suit, value; //initiates values to be accessed inside of class 
	
	String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"}; //suits
	String[] values = {"Ace of ", "King of ", "Queen of ", "Jack of ", "10 of ",
			"9 of ", "8 of ", "7 of ", "6 of ", "5 of ", "4 of ", "3 of ", "2 of "}; //values
	
	Card(int suit, int value) //card constructor 
	{
	        this.suit=suit;
	        this.value=value;
	}
	
	public int getSuit() //gets suit for card being constructed
	{
		return suit;
	}
	 
	public int getValue()  //gets value for card being constructed
	{
		return value;
	}
	
	public @Override String toString() //override to put object into deck array
	{
		return values[value]+suits[suit];
	}
}
