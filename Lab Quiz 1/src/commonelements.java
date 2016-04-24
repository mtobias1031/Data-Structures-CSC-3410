import java.util.Arrays;


public class commonelements 
{
	    public static void main(String args[])
	    {
	    	int[] array1 = new int[10];
	        int[] array2 = new int[10];
	        for(int k = 0; k < array1.length; k++) 
	        {
	    	      array1[k] = (int)(Math.random()*20);
	        }
	        for(int l = 0; l < array1.length; l++) 
	        {
	    	      array2[l] = (int)(Math.random()*30);
	        }
	    	      
	        System.out.println(Arrays.toString(array1));
	        System.out.println(Arrays.toString(array2) + "\n");
	        System.out.println("elements in common:");
	        	for(int i=0;i<array1.length;i++)
	        	{
	        		for(int j=0;j<array2.length;j++)	
	        		{
	        			if(array1[i]==array2[j])
	        			{
	        				System.out.println(array1[i]);
	        			}
	        		}
	        	}
	    }
}