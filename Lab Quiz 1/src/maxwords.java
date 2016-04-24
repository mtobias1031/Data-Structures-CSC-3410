import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class maxwords 
{
	public Map<String, Integer> getWordCount(String fileName)
	{
		FileInputStream fileinput = null;
        DataInputStream datainput = null;
        BufferedReader breader = null;
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        try
        {
            fileinput = new FileInputStream(fileName);
            datainput = new DataInputStream(fileinput);
            breader = new BufferedReader(new InputStreamReader(datainput));
            String line = null;
            while((line = breader.readLine()) != null)
            {
            	StringTokenizer stoken = new StringTokenizer(line, " ");
                while(stoken.hasMoreTokens())
                {
                	String tmp = stoken.nextToken().toLowerCase();
                    if(wordMap.containsKey(tmp))
                    {
                    	wordMap.put(tmp, wordMap.get(tmp)+1);
                    } 
                    else 
                    {
                        wordMap.put(tmp, 1);
                    }
                }
            }
        } 
        catch (FileNotFoundException e) 
        {
        	System.out.println("The file you entered cannot be found. Please try again");
        	e.printStackTrace();
        	System.exit(0);
        } 
        catch (IOException e) 
        {
        	System.out.println("The file you entered cannot be read. Please try again");
            e.printStackTrace();
            System.exit(0);
        } 
        finally
        {
            try
            {
            	if(breader != null) breader.close();
            }
            catch(Exception ex)
            {
            	System.exit(0);
            }
        }
        return wordMap;
	}
     
	public List<Entry<String, Integer>> sortByValue(Map<String, Integer> wordMap)
	{
        Set<Entry<String, Integer>> set = wordMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        });
        return list;
    }
     
    public static void main(String args[])
    {
    	Scanner scanner = new Scanner(System.in); //scanner to read file
		System.out.print("Enter the name of the file (must be in source folder) or file path you want to open: ");
		String filename = scanner.nextLine();
        maxwords mdc = new maxwords();
        Map<String, Integer> wordMap = mdc.getWordCount(filename);
        List<Entry<String, Integer>> list = mdc.sortByValue(wordMap);
        for(Map.Entry<String, Integer> entry:list)
        {
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
    }
}
