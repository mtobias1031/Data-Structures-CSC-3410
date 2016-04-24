/*Michael Tobias
 *Assignment 2 - wordcount.java
 *CSC 3410 - J.L. Bhola
 *Fall 2015
 *
 *The goal of this program is to take a file and read; thus returning the contents of the file, its word count,
 *number of lines, character count, number of sentences, number of vowels, and the number of punctuation characters.
 *The program achieves this by prompting the user to enter the file name to be used if it is located in the source file
 *or the file path if the text file is located elsewhere. From there the program imports the file and prints out the
 *word count, line count, character count, sentence count, vowel count, and punction count. These result are also written
 *to a file called "output.txt," which is saved in the source file location.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class wordcount 
{
	//main
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException 
	{
		
		Scanner scanner = new Scanner(System.in); //scanner to read file
		System.out.print("Enter the name of the file (must be in source folder) or file path you want open: ");
		String filename = scanner.nextLine(); //file name/ file path
		File file = new File(filename); //creates file object to be used
		String line = null;
		@SuppressWarnings("unused")
		boolean empty;
		int charcount = -2;
		
		System.out.println("");
		System.out.println("intput text: \n");
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");// main writer
		writer.println("input text: \n");
		
		try 
		{
			FileReader fileReader = new FileReader(filename); //file reader
			BufferedReader bufferedReader = new BufferedReader(fileReader); //buffer reader

			//while the file is not empty, this will print the contents of the file to the
			//console and to output.txt
			while((line = bufferedReader.readLine()) != null) 
			{	
				writer.println(line);
				System.out.println(line);
				charcount++;
			}
			//close buffer reader
			bufferedReader.close();         
		}
	    
		//exception for file that doesn't exist
		//returns that the file cannot be opened or doesn't exist. prints to console and output.txt
		//program terminates
		catch(FileNotFoundException ex) 
		{
			//handles exception
			System.out.println("Unable to open file or file does not exist '" + filename + "'"); 
			writer.print("Unable to open file or file does not exist '" + filename + "'");
			writer.close(); //closes writer
			System.exit(0);
		}
	    
		//exception for if file is corrupt or cannot be read
		//returns that the file cannot be read. prints to console and output.txt
		//program terminates
		catch(IOException ex) 
		{
			//handles exception
			System.out.println("Error reading file '"+ filename + "'");
			writer.print("Error reading file '"+ filename + "'");
			writer.close(); //closes writer
			System.exit(0);
		}
		
		//uses boolen object declared earlier to determine if file is empty
		//if file is empty, the program ends and prints that the file is empty on the console
		//and to output.txt. program terminates
		if(empty = file.length() == 0)
		{
			PrintWriter writer2 = new PrintWriter("output.txt", "UTF-8"); //new writer
			System.out.print("File is empty");
			writer2.print("File is empty");
			writer2.close();
			System.exit(0); //closes writer
		}
		
		String str = new Scanner(new File(filename)).useDelimiter("\\Z").next(); //pushes file to string
		
		//print to console
		System.out.print("\n");
		System.out.println("Words = " + getwordCount(file));
		System.out.println("Lines = " + getlineCount(file));
		System.out.println("Characters = " + getcharacterCount(file,charcount));   
		System.out.println("Sentences = " + getsentenceCount(str));
		System.out.println("Vowels = " + getvowelCount(str));
		System.out.println("Punctuation = " + getpuncCount(str));
		
		//print to output.txt
		writer.print("\n");
		writer.println("Words = " + getwordCount(file));
		writer.println("Lines = " + getlineCount(file));
		writer.println("Characters = " + getcharacterCount(file,charcount));   
		writer.println("Sentences = " + getsentenceCount(str));
		writer.println("Vowels = " + getvowelCount(str));
		writer.println("Punctuation = " + getpuncCount(str));
		writer.close(); //closes writer
	}
	
	//gets word count from file input
	private static int getwordCount(File file) 
	{
		int count = 0;
		try 
		{
			FileReader reader = new FileReader(file); //file reader
			@SuppressWarnings("resource")
			BufferedReader bufreader = new BufferedReader(reader); //buffer reader

			String line = bufreader.readLine(); //sets line to equal buffer, allowing word count to happen
			while (line != null) 
			{
				String[] parts = line.split(" "); //splits the string every time there is a space
				for (@SuppressWarnings("unused") String w : parts) //count goes up for every space counted
				{
					count++;
				}
				line = bufreader.readLine();//next line
			}
			
		} 
		
		//exception for file not found
		catch (FileNotFoundException e) 
		{
			//handles exception
			e.printStackTrace();
		} 
		
		//exception for IO
		catch (IOException e) 
		{
			//handles exception 
			e.printStackTrace();
		}
		//returns count total
		return count;
	}
	
	//gets line count from iput file
	private static int getlineCount(File file) 
	{
		int linecount = 0;
		FileReader reader = null; // file reader
		try 
		{
			reader = new FileReader(file); //new reader
			LineNumberReader lreader = new LineNumberReader(reader); //line reader
			
			while (lreader.readLine() != null) //while line reader is not empty, line count increases
			{
				linecount++;
			}
			// close line reader
			lreader.close();
			
			//returns line count
			return linecount;
			
		} 
		
		//exception for file note found
		catch (FileNotFoundException e) 
		{
			//handles exception
			e.printStackTrace();
		} 
		
		//exception for IO
		catch (IOException e) 
		{
			//handles exception
			e.printStackTrace();
		}

		finally 
		{
			if (null != reader)
				try 
				{	//closes reader
					reader.close();
				} 
				
				//exception for IO
				catch (IOException e) 
				{
					//handles exception
					e.printStackTrace();
				}	
		}
		//returns line count 
		return linecount;
	}
	
	//gets character count from input file
	private static int getcharacterCount(File file, int charcount) 
	{
		FileReader reader = null; //file reader
		int charCount = -1;

		try 
		{
			reader = new FileReader(file); //new reader
		    while (reader.read() > -1) //while reader is importing file, character count increases
		    {
		       charCount++;
   		    }

		} 
		
		//exception for file not found
		catch (FileNotFoundException e) 
		{
			//handles exception
			e.printStackTrace();
		} 
		
		//exception for IO
		catch (IOException e) 
		{
			//handles exception
			e.printStackTrace();
		}

		finally 
		{
			if (null != reader)
				try 
				{
					//closes reader
					reader.close();
				} 
				
				//exception for IO
				catch (IOException e) 
				{
					//handles exception
					e.printStackTrace();
				}
		}
		//returns character count
		return charCount - charcount;
	}
	
	//gets sentence count from input file
	public static int getsentenceCount(String str) 
	{
		String enders = ".?!"; //enders that cause sentence count to increase
		int sentenceCount = 0;
		int end=0; 
		for(int i=0;i < str.length(); i++) //loop to find enders
		{  
			for(int j=0;j < enders.length(); j++)
			{  
				if(str.charAt(i) == enders.charAt(j)) //if character at point = enders, counter increases
				{
					if(end != i-1)
					{
						sentenceCount++; //sentence counter
					}
					end = i;
				}
			}
		}
		//returns sentence count
		return sentenceCount;
	}
	
	//gets vowel count form input file
	public static int getvowelCount(String str) 
	{
		String vowels = "aeiouAEIOU"; //allows to search for uppercase and lowercase letters
		int vowelCount = 0;
		int end=0; 
		for(int i=0;i < str.length(); i++) //loop to find vowels
		{  
			for(int j=0;j < vowels.length(); j++)
			{  
				if(str.charAt(i) == vowels.charAt(j)) //if character = vowel, counter goes up
				{
					if(end != i-1)
					{
						vowelCount++; //vowel count
					}
					end = i;
				}
			}
		}
		//returns vowel count
		return vowelCount;
	}
	
	//gets punctuation count
	public static int getpuncCount(String str) 
	{
		String punc = "'[](){}<>:,-!.-?;/"; //searches for all punctuation
		int puncCount = 0;
		int end=0; 
		for(int i=0;i < str.length(); i++) //loop to find punctuation
		{  
			for(int j=0;j < punc.length(); j++)
			{  
				if(str.charAt(i) == punc.charAt(j)) //if character = punc, counter increases
				{
					if(end != i-1)
					{
						puncCount++; //punctuation count
					}
					end = i;
				}
			}
		}
		//returns punctuation count
		return puncCount;
	}
} //end program