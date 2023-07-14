package acadadminsystem_phase3;


public class InstructorLinkedList
{

    /**
       The Node class stores an Instructor element
       and a reference to the next node.
    */
    private class Node
    {
        Instructor value;   
        Node next;      
        
        /**
           Constructor.            
           @param val The element to store in the node.
           @param n The reference to the successor node.
        */
        Node(Instructor val, Node n)
        {
            value = val;
            next = n;
        } 
        
        /**
           Constructor. 
           @param val The element to store in the node.
        */
        Node(Instructor val)
        {
           // Call the other (sister) constructor.
           this(val, null);            
        }
    }	
	 
    private Node first;  // list head
    private Node last;   // last element in list
	     
    
    /**
       Constructor.
    */
    public InstructorLinkedList()
    {
        first = null;
        last = null;        
    }
    
    
    /**
       The isEmpty method checks to see 
		 if the list is empty.
		 @return true if list is empty, 
		 false otherwise.
    */
    public boolean isEmpty()
    {        
        return first == null;       
    }
    
    
    /**
       The size method returns the length of the list.
       @return The number of elements in the list.
    */
    public int size()
    {
       int count = 0;
       Node p = first;     
        while (p != null)
       {
           // There is an element at p
           count ++;
           p = p.next;
       }
       return count;
    }
    
    
    /**
       The add method adds an element to the end of the list.
       @param i The value to add to the end of the list.       
    */
    public void add(Instructor i)
    {
      if (isEmpty()) 
      {
          first = new Node(i);
          last = first;
      }
      else
      {
          // Add to end of existing list
          last.next = new Node(i);
          last = last.next;
      }      
    }
    
    
    /**
       The add method adds an element at a position.
       @param i The element to add to the list.
       @param index The position at which to add the element.
       @exception IndexOutOfBoundsException When index is out of bounds.  
    */
    public void add(int index, Instructor i)
    {
         if (index < 0  || index > size()) 
         {
             String message = String.valueOf(index);
             throw new IndexOutOfBoundsException(message);
         }
         
         // Index is at least 0
         if (index == 0)
         {
             // New element goes at beginning
             first = new Node(i, first);
             if (last == null)
                 last = first;
             return;
         }
         
         // Set a reference pred to point to the node that
         // will be the predecessor of the new node
         Node pred = first;        
         for (int k = 1; k <= index - 1; k++)        
         {
            pred = pred.next;           
         }
         
         // Splice in a node containing the new element
         pred.next = new Node(i, pred.next);  
         
         // Is there a new last element ?
         if (pred.next.next == null)
             last = pred.next;         
    }
    
    
    /**
       The toString method computes the string representation of the list.
       @return The string form of the list.
    */
    @Override
    public String toString()
    {
      StringBuilder strBuilder = new StringBuilder();
      
      // Use p to walk down the linked list
      Node p = first;
      while (p != null)
      {
         //strBuilder.append(p.toString() + "\n"); 
          strBuilder.append(p.value.toString() + "\n");
         p = p.next;
      }      
      return strBuilder.toString(); 
    }
    
    
    /**
       The remove method removes the element at an index.
       @param index The index of the element to remove. 
       @return The element removed.  
       @exception IndexOutOfBoundsException When index is out of bounds.     
    */
    public Instructor remove(int index)
    {
       if (index < 0 || index >= size())
       {  
           String message = String.valueOf(index);
           throw new IndexOutOfBoundsException(message);
       }
       
       Instructor element;  // The element to return     
       if (index == 0)
       {
          // Removal of first item in the list
          element = first.value;    
          first = first.next;
          if (first == null)
              last = null;             
       }
       else
       {
          // To remove an element other than the first,
          // find the predecessor of the element to
          // be removed.
          Node pred = first;
          
          // Move pred forward index - 1 times
          for (int k = 1; k <= index -1; k++)
              pred = pred.next;
          
          // Store the value to return
          element = pred.next.value;
          
          // Route link around the node to be removed
          pred.next = pred.next.next;  
          
          // Check if pred is now last
          if (pred.next == null)
              last = pred;              
       }
       return element;        
    }  
    
    
    /**
       The remove method removes an element.
       @param element The element to remove.
       @return true if the remove succeeded, false otherwise.
    */
    public boolean remove(Instructor element)
    {
       if (isEmpty()) 
           return false;      
      
       if (element.equals(first.value))
       {
          // Removal of first item in the list
          first = first.next;
          if (first == null)
              last = null;       
          return true;
       }
      
      // Find the predecessor of the element to remove
      Node pred = first;
      while (pred.next != null && !pred.next.value.equals(element))
      {
          pred = pred.next;
      }

      // pred.next == null OR pred.next.value is element
      if (pred.next == null)
          return false;
      
      // pred.next.value is element
      pred.next = pred.next.next;    
      
      // Check if pred is now last
      if (pred.next == null)
          last = pred;
      
      return true;       
    }
   
    
    /**
     * The find method finds the Instructor element in the list that has the 
     * first and last name specified in the parameters. If none is found, the 
     * method returns null.
     * @param instrFirstName First name of instructor to be found.
     * @param instrLastName last name of instructor to be found.
     * @return Instructor object with the given first and last name. Null if not found.
     */
    public Instructor find(String instrFirstName, String instrLastName)
    {
        // write implementation
        Node element = first;
       
        
        while( element != null)
        {
            if (element.value.getFirstName().equals(instrFirstName) && element.value.getLastName().equals(instrLastName))
            {
                return element.value;
            }
            element = element.next;
        }
        return null;
    }
    
    
    /**
     * The copy method returns a copy of the linked list.
     * @return A copy of the list.
     */
    public InstructorLinkedList copy()
    {
        InstructorLinkedList newList = new InstructorLinkedList();

        Node element = first;

        while( element != null )
        {
            if( element.value != null )
                newList.add(new Instructor(element.value));
            else
                newList.add(null);

            element = element.next;
        }
        return newList;
    }

    
}
