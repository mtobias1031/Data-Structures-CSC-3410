/*Michael Tobias
 *Assignment 6 - Bank.java
 *CSC 3410 - J.L. Bhola
 *Fall 2015
 *
 * The goal is of this assignment is to build experience with using queues in a bank simulation scenario.
 * This assignment uses one ADT, a queue, which is built on a linked list. This is the backbone of the application
 * for it keeps track of all incoming customers and keeps them in order until it is time for them to meet with
 * a teller. 
 * The way this program works, is upon start up it prompts user to run or not. if no is selected the program terminates.
 * If yes is selected, the program executes and begins to run for 2 minutes (120 seconds) and decreases with each passing
 * second until it reaches 0. While running, customers randomly arrive every 2-6 seconds and are placed in the queue. 
 * Each customer has a randomly generated time in which they will meet with the teller (2-5 seconds). Tellers come
 * available after a customers time expires. Customers can go to any of the 5 tellers as long as one is available and as
 * long as it is currently their turn to approach a teller. After 2 minutes, the program terminates. It returns 
 * the total number of customers who came to the bank, the number of customers each teller served, the total number of 
 * customers served, the time each teller spent helping customers, the total time spent helping customers, and the total 
 * number of customers who didn't make it to a teller.
 * 
 */

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Bank
{
	public static void main(String[] args) //main
	{
      
	Scanner input = new Scanner(System.in); //scanner
	
	while(true)
	{
    System.out.println("Would you like to run the bank simulation? Enter \"yes\" or \"no\": "); //output
    String selection = input.nextLine();  //reads user input
    selection.toLowerCase(); //converts to lower case

    //if yes, run simulation
    if (selection.equals("yes"))
    {  
    	
    //Declared variables for the application
    Runnable banksim = new Runnable()
    {
    Random rand = new Random();
    Queue<Integer> queue = new LinkedList<Integer>();
    boolean bt1, bt2, bt3, bt4, bt5 = false;
    boolean[] btArray = {bt1, bt2, bt3, bt4, bt5};
    int[] btArray2 = {(rand.nextInt(5 - 2) + 2),(rand.nextInt(5 - 2) + 2),(rand.nextInt(5 - 2) + 2),
    		(rand.nextInt(5 - 2) + 2),(rand.nextInt(5 - 2) + 2)};
    int time = 0;
    int bc1, bc2, bc3, bc4, bc5;
    int custServed1, custServed2, custServed3, custServed4, custServed5 = 0;
    int Time1, Time2, Time3, Time4, Time5 = 0;
    int b1, b2, b3, b4, b5 = 1;
    
    // Method executes the simulation
    public void run()
    {
    if(time == 120) //stops once time is equal to 120 and prints the following statements upon completion
    {
    System.out.println((custServed1 + custServed2+ custServed3 + custServed4 + custServed5 + 5 + queue.size()) + 
    		" customers visited the bank.");
    System.out.println("Teller 1 helped " + (custServed1 + 1) + " customers. Totaling a time of " + Time1 + " secs.");
    System.out.println("Teller 2 helped " + (custServed2 + 1) + " customers. Totaling a time of " + Time2 + " secs.");
    System.out.println("Teller 3 helped " + (custServed3 + 1) + " customers. Totaling a time of " + Time3 + " secs.");
    System.out.println("Teller 4 helped " + (custServed4 + 1) + " customers. Totaling a time of " + Time4 + " secs.");
    System.out.println("Teller 5 helped " + (custServed5 + 1) + " customers. Totaling a time of " + Time5 + " secs.");
    System.out.println((custServed1 + custServed2 + custServed3
    		+ custServed4 + custServed5 + 5) + " customers were served in total.");
    System.out.println("Tellers were occupied with customers for a total time of " + (Time1 + Time2 + Time3
    		+ Time4 + Time5) + " seconds.");
    if(queue.size() == 1)
	{
        System.out.println(queue.size() + " customer didn't make it to a teller.");
	}
	else
	{
	    System.out.println(queue.size() + " customers didn't make it to a teller.");
	}
    System.exit(0);
    }

    //when the time isn't equal to 120, the program executes based on the assignment requirements
    else
    {
    	if(rand.nextInt(4) < 6)
    	{
    		int btime = (rand.nextInt(5 - 2) + 3); //time with teller
    		queue.add(btime);	
    	}

    	while(b1 == 1) //teller1
    	{   
    		bc1 = time;
    		b1 = 0;
    	}
    	if ((time - bc1) >= btArray2[0])
    	{
    		btArray[0] = true;
    		if (btArray[0] == true && queue.isEmpty() == false)
    		{
    			Time1 += btArray2[0];
    			btArray2[0] = queue.poll();
    			b1 = 1;
    			custServed1++;
    		}
    	}
    	
    	while(b2 == 1) //teller2
    	{
    		bc2 = time;
    		b2 = 0;
    	}
    	if ((time - bc2) >= btArray2[1])
    	{
    		btArray[1] = true;
    		if (btArray[1] == true && queue.isEmpty() == false)
    		{
    			Time2 += btArray2[1];
    			btArray2[1] = queue.poll();
    			b2 = 1;
    			custServed2++;
    		}
    	}

    	while(b3 == 1) //teller3
    	{
    		bc3 = time;
    		b3 = 0;
    	}
    	if ((time - bc3) >= btArray2[2])
    	{
    		btArray[2] = true;
    		if (btArray[2] == true && queue.isEmpty() == false)
    		{
    			Time3 += btArray2[2];
    			btArray2[2] = queue.poll();
    			b3 = 1;
    			custServed3++;
    		}
    	}

    	while(b4 == 1) //teller4
    	{
    		bc4 = time;
    		b4 = 0;
    	}
    	if ((time - bc4) >= btArray2[3])
    	{
    		btArray[3] = true;
    		if (btArray[3] == true && queue.isEmpty() == false)
    		{
    			Time4 += btArray2[3];
    			btArray2[3] = queue.poll();
    			b4 = 1;
    			custServed4++;
    		}
    	}  
    	
    	while(b5 == 1) //teller5
    	{
    		bc5 = time;
    		b5 = 0;
    	}
    	if ((time - bc5) >= btArray2[4])
    	{
    		btArray[4] = true;
    		if (btArray[4] == true && queue.isEmpty() == false)
    		{
    			Time5 += btArray2[4];
    			btArray2[4] = queue.poll();
    			b5 = 1;
    			custServed5++;
    		}
    	}
    	
    	time++;
    	//output while program is running
    	if(queue.size() == 1)
    	{
    		System.out.println("Current queue count: " + queue.size() + " customer.");
    	}
    	else
    	{
    		System.out.println("Current queue count: " + queue.size() + " customers.");
    	}
    	System.out.println((120 - time) + " secs left in the bank simulation.");
    	System.out.println("--------");
    }
    }
    };
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    executor.scheduleAtFixedRate(banksim, 0, 1, TimeUnit.SECONDS);
    
    	}
    else if (selection.equals("no")) //if no, program terminates
    {
    	System.out.println("Exiting program");
        System.exit(0); //exit 
    }
    else
    {      
    	System.out.println("Incorrect input. Enter yes or no: "); //if input is not yes or no, program ask again	
    }
    }
    }
}//end