/*Michael Tobias
 *Assignment 1 - Deck.java
 *CSC 3410 - J.L. Bhola
 *Fall 2015
 *
 *This program uses two classes (Deck.java and Card.java) to create a deck of cards. This deck of cards is then
 *printed in order. It is then shuffled 40 times and printed again. Card.java stores the card values and suits.
 *Deck.java then constructs the deck and handles shuffling using getter methods in Card.java.
 */

package cardgame;

import java.util.*;

public class Deck 
{
	public static void main(String[] args) //main
	{
		@SuppressWarnings("unused")
		Deck deck = new Deck();	//creates new deck. Calls on Deck() constructor to build and shuffle deck
	} //end main
	
	Card[] cards; //initiated array
	int numofcards = 52; //size of array
	@SuppressWarnings("rawtypes")
	Vector deck; //initiated vector

	@SuppressWarnings({ "unchecked", "rawtypes" })
	Deck() //Deck Constructor
	{
		cards = new Card[52];
		int x=0;
		for (int s=0; s<=3; s++) //for the suits
		{
			for (int v=0; v<=12; v++) //for the values
			{
				cards[x] = new Card(s,v); //adds each card value and suit to the array
				x++;
			}
		} 
		deck = new Vector(Arrays.asList(cards)); //pushes array into vector
	        
		System.out.println("Deck in order");
		System.out.println("--------------------\n");
		for(int j = 0; j < deck.size() ; j++)
		{
			System.out.println(deck.get(j)); //prints deck in order, line by line
		}
	        
		System.out.print("\n");
		System.out.println("Deck shuffled 40 times:");
		System.out.println("--------------------\n");
			
		for(int k = 0 ; k < 2080; k++) //creates 2080 random numbers
		{
			Random n = new Random();
			int Low = 0;
			int High = 52;
			int N = n.nextInt(High-Low) + Low; //creates a random number between 0-52, 2080 times. 52*40=2080
			
			if (N < deck.size())
			{
				Object replace = deck.get(N); //saves current value in vector
				deck.remove(N); //removes the current value
				deck.add(replace); //adds the saved value to the end of the vector
			}
		}
				
		for(int i = 0; i < deck.size() ; i++)
		{
			System.out.println(deck.get(i)); //prints shuffled deck, line by line
		}		
	} //end constructor
} //end of program

