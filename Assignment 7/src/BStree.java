/*Michael Tobias
 *Assignment 7 - BStree.java
 *CSC 3410 - J.L. Bhola
 *Fall 2015
 *
 *The purpose of this assignment is to get experience with Binary Search trees. This is accomplished using a linked list which is built using an
 *integer array which is populated with 100 random numbers that are between 1-99. The numbers are inserted into the array one by one. 
 *the bst class takes the array and inputs one number at a time into the tree, creating an ordered tree using the insert method. 
 *The bst class also contains the method to print the numbers in order when it is called.
 *This class works with the bstnode class, which is the blueprint for the tree. The bstnode class contains all the getters and setters for 
 *the program. BStree is the main class and it creates the random numbers that are inserted into the array in no order. 
 *BStree then passes the random array to the bst class where they are inserted in an orderly fashion. Lastly the class uses a 
 *recursive method to print the inorder (infix) upon calling and it prints the no order array using a for loop.
 *
 */

import java.util.Random;
 
 //Class BSTNode
 class BSTNode
 {
     BSTNode left;
     BSTNode right;
     int data;
 
     //Constructor
     public BSTNode()
     {
         left = null;
         right = null;
         data = 0;
     }
     
     //Constructor
     public BSTNode(int n)
     {
         left = null;
         right = null;
         data = n;
     }
     
     //Function to set left node
     public void setLeft(BSTNode n)
     {
         left = n;
     }
     
     //Function to set right node 
     public void setRight(BSTNode n)
     {
         right = n;
     }
     
     //Function to get left node
     public BSTNode getLeft()
     {
         return left;
     }
     
     //Function to get right node
     public BSTNode getRight()
     {
         return right;
     }
     
     //Function to set data to node
     public void setData(int d)
     {
         data = d;
     }
     
     //Function to get data from node
     public int getData()
     {
         return data;
     }     
 }
 
 //Class BST
 class BST
 {
     private BSTNode root;
 
     //Constructor
     public BST()
     {
         root = null;
     }
     
     //Functions to insert data
     public void insert(int data)
     {
         root = insert(root, data);
     }
     
     //Function to insert data recursively
     private BSTNode insert(BSTNode node, int data)
     {
         if (node == null)
             node = new BSTNode(data);
         else
         {
             if (data <= node.getData())
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         return node;
     }
     
     //Function for inorder traversal
     public void inorder()
     {
         inorder(root);
     }
     
     private void inorder(BSTNode r)
     {
         if (r != null)
         {
             inorder(r.getLeft());
             System.out.print(r.getData() +" ");
             inorder(r.getRight());
         }
     }  
 }
 
 //Class BSTree
 public class BStree
 {
     public static void main(String[] args) //main
     {                 
        
        BST bst = new BST(); //initiates BST
                
        int [] rand = new int[100];
        rand = linkedlist(); //initiates linkedlist
        printA(rand); //prints the random integers in no order
        for(int i=0; i < rand.length; i++) //insertion loop
        {
            bst.insert(rand[i]);
        }
        System.out.print("\nInfix Expression: ");
        bst.inorder(); //prints inorder          
    }
     
     //Generates 100 random values between 1-99
     private static int[] linkedlist() //linkedlist
     {
        int [] a = new int[100];
        Random randomGenerator = new Random();
        for(int i=0; i < a.length ;i++)
        {
            int randomInt = randomGenerator.nextInt(98)+1;
            a[i] = randomInt;   
        }
        return a;
    }
    
    //Prints int[] array values
    private static void printA(int[] a)
    {
        System.out.print("Random Numbers: ");
        for(int j = 0; j < a.length ; j++)
        {
            System.out.print(a[j]+" ");
        }
        System.out.println("");
    }
 }