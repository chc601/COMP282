import java.util.Scanner;
import java.util.Random;

//Class Node//
class Node                          
{
   protected int data;
   protected Node link;
 
   public Node()                    //Constructors//
   {
      link = null;
      data = 0;
   }    
   public Node(int d,Node n)
   {
      data = d;
      link = n;
   }    
   
   public void setLink(Node n)      //Function to set link to next Node//
   {
      link = n;
   }    
    
   public void setData(int d)       //Function to set data to current Node//
   {
      data = d;
   }    
    
   public Node getLink()            //Function to get link to next node//
   {
      return link;
   }    
    
   public int getData()             //Function to get data from current Node//
   {
      return data;
   }
}
 
//Class linkedList//
class linkedList
{
   protected Node start;
   protected Node end;
   public int size;
   public long elapsedTime;
 
   public linkedList()              //Constructor//
   {
      start = null;
      end = null;
      size = 0;
   }

   public boolean isEmpty()         //Function to check if list is empty//
   {
      return start == null;
   }
    
   public int getSize()             //Function to get size of list//
   {
      return size;
   }    
   
   public int RandomInteger(int n)  //Generate a random in the range 0..(n-1)//
   {
       Random randomGenerator = new Random();
       int randomInt = randomGenerator.nextInt(n);  
       return randomInt;
   }
    
    
   public void insertAtStart(int val)   //To insert an element at begining//
   {
      int insval;
      long startTime = 0, stopTime = 0;
      for(int i = 0; i < val; i++)
      {
         insval = RandomInteger(val);
         Node nptr = new Node(insval, null);    
         size++ ;    
         startTime = System.currentTimeMillis();
         if(start == null) 
         {
            start = nptr;
            end = start;
         }
         else 
         {
            nptr.setLink(start);
            start = nptr;
         }
         stopTime = System.currentTimeMillis();
         elapsedTime = elapsedTime + stopTime - startTime;
      }
   }
    
   public void insertAtEnd(int val)     //To insert an element at end//
   {
      int insval;
      long startTime = 0, stopTime = 0;
      for(int i = 0; i < val; i++)
      {
         insval = RandomInteger(val);
         Node nptr = new Node(insval,null);    
         size++ ;    
         startTime = System.currentTimeMillis();
         while (start != null)
            start.getLink();
         if(start == null) 
         {
            start = nptr;
            end = start;
         }
         else 
         {
            end.setLink(nptr);
            end = nptr;
         }   
         stopTime = System.currentTimeMillis();
         elapsedTime = elapsedTime + stopTime - startTime;
      }
   }
    
   public void insertAtPos(int val)    //To insert an element at position//
   {
      int insval, pos;
      for(int i = 0; i < val; i++)
      {
         insval = RandomInteger(val);
         Node nptr = new Node(insval,null); 
         if(start == null) 
         {
            start = nptr;
            end = start;
         }
         else
         {    
            Node ptr = start;
            pos = RandomInteger(size);
            for (int j = 1; j < size; j++) 
            {
               if (j == pos) 
               {
                  Node tmp = ptr.getLink() ;
                  ptr.setLink(nptr);
                  nptr.setLink(tmp);
                  break;
               }
               ptr = ptr.getLink();
            }
         }
         size++ ;
      }
   }      
      
   public void deleteAtPos(int pos)        //To delete an element at position//
   {    
      if (pos == 1) 
      {
         start = start.getLink();
         size--; 
         return ;
      }
      if (pos == size) 
      {
         Node s = start;
         Node t = start;
         while (s != end)
         {
            t = s;
            s = s.getLink();
         }
         end = t;
         end.setLink(null);
         size --;
         return;
      }
      Node ptr = start;
      pos = pos - 1 ;
      for (int i = 1; i < size - 1; i++) 
      {
         if (i == pos) 
         {
            Node tmp = ptr.getLink();
            tmp = tmp.getLink();
            ptr.setLink(tmp);
            break;
         }
         ptr = ptr.getLink();
      }
      size-- ;
   }       
        
   public void display()                //To display elements//
   {
      System.out.print("\nSingly Linked List = " + size + " items\n" );
      if (size == 0) 
      {
         System.out.print("empty\n");
         return;
      }    
      if (start.getLink() == null) 
      {
         System.out.println(start.getData() );
         return;
      }
      Node ptr = start;
      int pos = 1;
      System.out.print("\n" + pos + ": " + start.getData()+ "\n");
      ptr = start.getLink();
      while (ptr.getLink() != null)
      {
         pos++;
         System.out.print(pos + ": " + ptr.getData()+ "\n");
         ptr = ptr.getLink();
      }
      System.out.print(pos+1 + ": " +ptr.getData()+ "\n\n");
      System.out.println("Time elapsed :" + elapsedTime + " millisecondsn\n");
   }
}
 
/*  Class SinglyLinkedList  */
public class SinglyLinkedList
{    
   public static void main(String[] args)
   {  
      Scanner scan = new Scanner(System.in);
      linkedList list = new linkedList();   //Creating object of class linkedList//       
      linkedList listB = new linkedList();  //To add at the begininnig of the list//  
      linkedList listE = new linkedList();  //To add at the end of the list//  
      linkedList listA = new linkedList();  //To add at any place of the list//  
      System.out.println("Singly Linked List Test\n");          
      char ch;
      do                                    //Perform list operations//
      {
         System.out.println("\nSingly Linked List Operations\n");
         System.out.println("1. 1,000 items");
         System.out.println("2. 10,000 items");
         System.out.println("3. 100,000 items");             
         int choice = scan.nextInt();            
         switch (choice)
         {
            case 1 : 
               System.out.println("Insert, Remove, and get for 1,000");
               listB.insertAtStart(10);      //Insert at the beginning//
               listB.display();                                     
//               listE.insertAtEnd(10);      //Insert at the end//
//              listE.display();              
//               listA.insertAtPos(10);      //Insert at random position//
//               listA.display();                   
               break;   
/*                                      
            case 2 : 
               System.out.println("Enter integer element to insert");
               list.insertAtEnd( scan.nextInt() );                     
               break;                         
            case 3 : 
               System.out.println("Enter integer element to insert");
               int num = scan.nextInt() ;
               System.out.println("Enter position");
               int pos = scan.nextInt() ;
               if (pos <= 1 || pos > list.getSize() )
                  System.out.println("Invalid position\n");
               else
                  list.insertAtPos(num, pos);
               break;                                          
            case 4 : 
               System.out.println("Enter position");
               int p = scan.nextInt() ;
               if (p < 1 || p > list.getSize() )
                  System.out.println("Invalid position\n");
               else
                  list.deleteAtPos(p);
               break;          
            case 5 : 
               System.out.println("Empty status = "+ list.isEmpty());
               break;                   
            case 6 : 
               System.out.println("Size = "+ list.getSize() +" \n");
               break;                         
            default : 
               System.out.println("Wrong Entry \n ");
               break;   
 */              
         }
//         list.display();                    /*  Display List  */ 
         System.out.println("\nDo you want to continue (Type y or n) \n");
         ch = scan.next().charAt(0);                        
      } while (ch == 'Y'|| ch == 'y');               
   }
}