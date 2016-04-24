package quiz2;

public class linkedlist 
{
	private Node head;
    private int count;
 
    public linkedlist() 
    {
        head = new Node(null);
        count = 0;
    }
    
    public void add(Object data)
    {
        Node listtemp = new Node(data);
        Node listcur = head;
        
        while (listcur.getNext() != null) 
        {
            listcur = listcur.getNext();
        }
        
        System.out.println(data + " has been set and added to the linked list at position " + (count+1));
        listcur.setNext(listtemp);
        count++;
    }
    
    public Object get(int index)
    {
        if (index <= 0)
            return null;
        
        Node listcur = head.getNext();
        
        for (int i = 1; i < index; i++) 
        {
            if (listcur.getNext() == null)
                return null;
            
            listcur = listcur.getNext();
        }
        
        return listcur.getData();
    }
 
    public boolean remove(int index)
    {
        if (index < 1 || index > size())
            return false;
 
        Node listcur = head;
        
        for (int i = 1; i < index; i++) 
        {
            if (listcur.getNext() == null)
                return false;
            
            listcur = listcur.getNext();
        }
        
        listcur.setNext(listcur.getNext().getNext());
        count--;
        return true;
    }
 
    public int size()
    {
    	System.out.println("The current size of the linked list is " + count + "\n");
        return count;
    }
 
    public String toString() 
    {
        Node listcur = head.getNext();
        String output = "";
        
        while (listcur != null)
        {
            output += "[" + listcur.getData().toString() + "]";
            listcur = listcur.getNext();
        }
        return output;
    }
 
    public class Node 
    {
        Node next;
        Object data;
 
        public Node(Object dataValue) 
        {
            next = null;
            data = dataValue;
        }
  
        public Object getData() 
        {
            return data;
        }
  
        public Node getNext()
        {
            return next;
        }
 
        public void setNext(Node nextValue) 
        {
            next = nextValue;
        }
    }
}