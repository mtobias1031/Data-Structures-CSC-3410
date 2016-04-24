import java.util.*;

public class mystack 
{
	public int size;
	private long[] stackarray;
	private int top;
	
	public mystack(int s)
	{
		size = s;
		stackarray = new long[size];
		top = 0;
	}
	
	public void contain(long j)
	{
		for (int i = 0; i < stackarray.length; i++)
	    {
			if(stackarray[i] == j)
			{
				System.out.println("\npop, " + j + " is in the stack");
			}
	    }
	}
	
	public void push(long j)
	{
		System.out.println(j + " has been added to the stack");
		stackarray[++top] =j;
	}
	
	public long pop()
	{
		return stackarray[top--];
	}
	
	public long peek()
	{
		System.out.println("\n"+ top + " is at the top of the stack");
		return stackarray[top];
	}
	
	public boolean isempty()
	{
		return (top == 0);
	}
	
	public boolean isfull()
	{
		if(top == size)
		{
			System.out.println("\nstack is full");
		}
		else
		{
			System.out.println("\nstack is not full");
		}
		return (top == size);
	}
	
	public static void main(String[] args)
	{
		mystack stack = new mystack(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		//stack.peek();
		System.out.println("\nCurrent Stack \n===============");
		
		while(!stack.isempty())
		{
			long value = stack.pop();
			System.out.println(value);
		}
		//stack.isfull();
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEnter a value to search for in the stack:");
		
		String input = scanner.nextLine();
		long l = Long.parseLong(input);
		stack.contain(l);
		
	}
}
