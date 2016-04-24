package calc;

/*Michael Tobias
 *Assignment 5 - calculator.java
 *CSC 3410 - J.L. Bhola
 *Fall 2015
 *
 *The goal of this assignment is to gain experience in using stacks with postfix/infix calculators. 
 *To accomplish this task, a stack is used as the data structure.
 *The program works by taking user input of an equation in infix form. 
 *Once the equation is entered it is check to confirm it complies with operational/mathematical logic.
 *If there is any error in the the equation (no operator between operands, floating points, missing left or right parentheses, 
 *or an operator followed by another operator)
 *The program will automatically exit and return a error statement.
 *After checking, the infix is converted into postfix and returned. It then prompts the user for the value of X and then calculates and returns the calculated answer. 
 *
 */

import java.util.*;

public class calculator
{
	private Stack <Character> s; //stack
          
	public static void main(String[] args) //main
	{
		calculator p = new calculator(); //calculator
		p.execute(); //initiates calculator
           
	}

	//executes program
	public void execute()
	{
		System.out.println("Enter infix equation (Please enter negative numbers as (0-X) if you use any:  \n");
		String k = toPostfix(input());
		System.out.println("Enter a value for X:  ");
		int x = inputInt();
		evaluatePostfix(k,x);   
	}
        
	//Method to take user input and put into a String
	public String input()
	{
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		return str;    
	}
      
	//Method to take user input and put into an int value
	public int inputInt()
	{
		Scanner input = new Scanner(System.in);
		int in = input.nextInt();
        return in;
	}
        
	//method to convert infix expression to postfix. takes in a string which is captured from the user imput
	public String toPostfix(String str)
	{
		String postfix = "";
		String pfix = "";
		s = new Stack<Character>();
		int right = 0;
		int left = 0;
		char previous = str.charAt(0);        
            
		str = str.replaceAll("\\s",""); //removes all white space from String
		str = str.toLowerCase(); //makes string all lowercase
		
		for(int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
                
			char last = str.charAt(str.length() - 1);
			
			//This statement checks the last character of the infix expression.  If operator, informs the user
			//and terminates program.
			if (isOperator(last))
			{
				System.out.print("\nError in expression!! Last token must be an operand.");
				System.exit(1);
			}
			
			//This statement checks for periods within the string.  If a period is found, informs the user
			//and terminates program.
			if(str.indexOf('.') != -1)
			{
				System.out.print("\nError in expression!! Cannot accept floating point numbers.");
				System.exit(1);
			}
			
			if (isOperator(c))
			{
				if(previous!=')'|| previous!='(')
				{
					pfix += " ";
				}
                    
				//This statement checks for missing operator between parentheses.  If missing, informs the user
				//and terminates program
				if(previous == '(')
				{
					System.out.print("\nError in expression!! No operator between operand and left parentheses."); 
					System.exit(1);
				}
                    
				//statement checks for if an operator is succeeded by another operator. If true, terminates program
				if(isOperator(previous))
				{
					System.out.print("\nError in expression!! An operator cannot be preceded by another operator."); 
					System.exit(1);
				}
				
				while(!s.isEmpty() && s.peek()!='(' && highPriority(s.peek(),c))
				{
					postfix += s.peek();
					pfix += s.peek();
					s.pop();
				} 
				s.push(c);
			}
                
			else if(isOperand(c)) 
			{  
				postfix += c;
				pfix += c;
			}
			
			else if( c =='(' )    
			{  
				left++; 
				s.push(c);  
			}      
			
			else if( c ==')' )
			{     
				right++;
				
				//This statement checks for missing parentheses.  If missing, informs the user
				//and terminates program
				if(right>left)
				{
					System.out.print("\nError in expression!! No matching left parentheses for a right parentheses.");
					System.exit(1);                   
				}
				
				while(!s.isEmpty() && s.peek() != '(')
				{
					postfix += s.peek();
					pfix += s.peek();
					s.pop();
				}
				s.pop();                    
			}
            previous = c;    
		}   
		
		while(!s.isEmpty())
		{
			postfix += s.peek();
			pfix += s.peek();
			s.pop();
		}
		
		//This statement checks for missing parentheses.  If missing, informs the user
		//and terminates program
		if( isRightFormat(right,left) > 0)
		{
			System.out.println("\nError in expression!! No matching left parentheses for a right parentheses.");
			System.exit(1);
		} 
		
		//This statement checks for missing parentheses.  If missing, informs the user
		//and terminates program
		if( isRightFormat(right,left) < 0)
		{
			System.out.println("\nError in expression!! No matching right parentheses for a left parentheses.");
			System.exit(1);
		}
            
		System.out.print("Converted Expression: "+postfix+"\n");
		return pfix; //returns string in postfix
	}
        
	//Method calculates the value of the postfix expression. uses string and integer captured from user input
	public void evaluatePostfix(String str, int x) 
	{
		Stack<Integer> stack = new Stack <Integer>();
		String optione1 = "";
		String optione2 = "";
		int option1, option2, option;
		int count = 0;
		String cstr = "";
		int result = 0;
		char previous = str.charAt(0);
               
		String var = Integer.toString(x);    //converts integer to string
		str = str.replaceAll("x",var);       //replaces x with input value
            
            
		for (int j =0;j<str.length(); j++)
		{
			char c = str.charAt(j);
			if(c==' ' && isOperator(previous))
			{
				continue;
			}
            
			if(isOperator(c) && previous==' ')
			{
				cstr = cstr.substring(0,cstr.length()-1) + c;
			} 
			else cstr += c;
                previous = c;  
		}
  
		previous = cstr.charAt(0);
          
		for(int i = 0; i<cstr.length(); i++)
		{ 
			char c = cstr.charAt(i);    
			
			if(isOperand(c))
			{
				if(count%2==0)
				{
					optione1 += c;
				}
				else
				{
					optione2 += c;
				}
			}

			else if(c==' ' && count%2==0 || !isOperator(previous) && isOperator(c) && count%2==0)
			{
				count++;
				option = Integer.parseInt(optione1);
				stack.push(option);
				optione1 = "";
			}
			
			else if(c==' ' && count%2!=0 || !isOperator(previous) && isOperator(c) && count%2!=0)
			{
				count++;
				option = Integer.parseInt(optione2);
				stack.push(option);
				optione2 = "";
			}     
            
			if(isOperator(c)) //operator switch
			{        
				option2 = stack.peek();
				stack.pop();
				
				option1 = stack.peek();
				stack.pop();
                               
				switch (c)  //switch
				{
				case '/': result = option1 / option2; break;
				case '*': result = option1 * option2; break;
				case '^': result = (int) Math.pow(option1, option2); break;
				case '+': result = option1 + option2; break;
				case '-': result = option1 - option2; break;
				case '%': result = option1 % option2; break;
				default:
					break;                            
				}
				stack.push(result);
			}

			previous = c;    
		}
            
		result = stack.peek();
		stack.pop();
                
		System.out.println("The result is: "+result+"\n");
	}                    
        
	//Method to verify if a character is an operand or not.
	public boolean isOperand(char c)
	{
		if(c >= '0'  && c <= '9') return true;
		if(c >= 'a'  && c <= 'z') return true;
		if(c >= 'z'  && c <= 'Z') return true;
		else return false;
	}
        

	//Method to verify if a character is an operator or not.
	public boolean isOperator(char option)
	{
		switch(option)
		{
		case '+': return true;
		case '-': return true;
		case '/': return true;
		case '*': return true;
		case '%': return true;
		default: return false;
		}
	}
        
	//Method to determine the highest priority of two operators
	public boolean highPriority(char option1, char option2)
	{
        int op1Weight = priorityLevel(option1);
        int op2Weight = priorityLevel(option2);
        
        if(op1Weight < op2Weight)
        	return false;
        else
            return true;
	} 
            
        
	//Method to set priority to operators
	public int priorityLevel(char option)
	{
            int pl;
            switch(option)
            {
                case '+': case'-': pl =1; break;
                case '*': case'/': case'%': pl=2; break;
                default: pl = -1;
            }
            return pl;
	}

    //method to make sure equation is correct    
	public int isRightFormat(int r, int l)
	{
		if (r == l) return 0;
		if (r > l)  return 1;
		else return -1;
	}
}
