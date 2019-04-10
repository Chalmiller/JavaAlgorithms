package llist2;
/**
   A class that implements the ADT list by using a chain of nodes.
   The chain has both a head reference and a tail reference.
   @author Frank M. Carrano
   @version 3.0
*/
public class LList2<T> implements ListInterface<T>
{
	private Node firstNode; // head reference to first node
	private Node lastNode;  // tail reference to last node
	private int  numberOfEntries;

	public LList2()
	{
            clear();
	} // end default constructor

	public final void clear() 
        // NOTICE clear is not final in interface and that is OK
	{
		firstNode = null;
  		lastNode = null;
		numberOfEntries = 0;
	} // end clear
  
	public void add(T newEntry) 	  // OutOfMemoryError possible
	{
		Node newNode = new Node(newEntry); // create new node

		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		
  		lastNode = newNode;
  		numberOfEntries++;
	}  // end add

   public boolean add(int newPosition, T newEntry)  // OutOfMemoryError possible	                                                 
	{
      boolean isSuccessful = true;

      if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) 
      {
         Node newNode = new Node(newEntry);

         if (isEmpty())
         {
            firstNode = newNode;
            lastNode = newNode;
         }
         else if (newPosition == 1)
         {
            newNode.setNextNode(firstNode);
            firstNode = newNode;
         }
         else if (newPosition == numberOfEntries + 1)
         {
            lastNode.setNextNode(newNode);
            lastNode = newNode;
         } 
         else
         {
            Node nodeBefore = getNodeAt(newPosition - 1);
            Node nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);
         } // end if	    
         numberOfEntries++;
      }
      else
         isSuccessful = false;
       
	   return isSuccessful;
	} // end add

public T remove(int givenPosition)
	{
      T result = null;                 // return value

      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         assert !isEmpty();
         if (givenPosition == 1)        // case 1: remove first entry
         {
            result = firstNode.getData();     // save entry to be removed 
            firstNode = firstNode.getNextNode();
            if (numberOfEntries == 1)
               lastNode = null; // solitary entry was removed
            }
            else                           // case 2: givenPosition > 1
            {
               Node nodeBefore = getNodeAt(givenPosition - 1);
               Node nodeToRemove = nodeBefore.getNextNode();
               Node nodeAfter = nodeToRemove.getNextNode();
               nodeBefore.setNextNode(nodeAfter);  // disconnect the node to be removed
               result = nodeToRemove.getData();  // save entry to be removed

               if (givenPosition == numberOfEntries)
                  lastNode = nodeBefore; // last node was removed
         } // end if

         numberOfEntries--;
      } // end if

      return result;                   // return removed entry, or 
                                      // null if operation fails
	} // end remove

	public boolean replace(int givenPosition, T newEntry)
	{
		boolean isSuccessful = true;

      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {   
      	assert !isEmpty();

			Node desiredNode = getNodeAt(givenPosition);
			desiredNode.setData(newEntry);
      }    
		else
			isSuccessful = false;
			
		return isSuccessful;
   } // end replace

   public T getEntry(int givenPosition)
   {
      T result = null;  // result to return
      
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
         result = getNodeAt(givenPosition).getData();
     	} // end if
      
      return result;
   } // end getEntry

public boolean contains(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		} // end while
		
		return found;
	} // end contains

   public int getLength()
   {
      return numberOfEntries;
   } // end getLength

   public boolean isEmpty()
   {
   		boolean result;
   		
      	if (numberOfEntries == 0) // or getLength() == 0
      	{
      		assert firstNode == null;
      		result = true;
      	}
      	else
      	{
      		assert firstNode != null;
      		result = false;
      	} // end if
      	
      	return result;
   } // end isEmpty
	
   public T[] toArray()
   {
      // the cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // warning: [unchecked] unchecked cast

	  int index = 0;
     Node currentNode = firstNode;
	  while ((index < numberOfEntries) && (currentNode != null))
	  { 
	    result[index] = currentNode.getData();
	    currentNode = currentNode.getNextNode();
       index++; 
	  } // end while
     
     return result;
   } // end toArray

	// Returns a reference to the node at a given position.
	// Precondition:  List is not empty; 1 <= givenPosition <= numberOfEntries.	
	private Node getNodeAt(int givenPosition)
	{
		assert (firstNode != null) && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;
		
      if (givenPosition == numberOfEntries)
         currentNode = lastNode;
      else if (givenPosition > 1)      // traverse the chain to locate the desired node
		{
         for (int counter = 1; counter < givenPosition; counter++)
            currentNode = currentNode.getNextNode();
		} // end if
      
		assert currentNode != null;
		return currentNode;
	} // end getNodeAt

        /** int getLastIndex(T item) 
          * that returns the index of the last entry which is equal to item. 
          * If item is not found, it returns -1.
          */
	int getLastIndex(T item) {
            
            Node currentNode = firstNode;
            
            int highIndex = 0, index = 0;

            while (index < numberOfEntries && currentNode != null){
		if (item.equals(currentNode.getData())) {
                    highIndex = index;
                    index++;
                }   
                    else {
                    currentNode = currentNode.getNextNode();
		} 
            }
            if (highIndex == 0) {
                return 0;
            } else {
                return highIndex;
            }
	}
        
        /** int removeEvery(T item) that removes all occurrences of item 
          *  and returns the number of removed items.
          */
	int removeEvery(T item) {
            
            Node currentNode = firstNode;
            int index = 0;
            int count = 0;
            
            while (index < numberOfEntries && currentNode != null){
		if (item.equals(currentNode.getData())) {
                    currentNode.setData(null);
                    index++;
                    count++;
                } else {
                    currentNode = currentNode.getNextNode();
                } // end while
            }
            return count;
	}
        
	/** boolean equals(Object other) 
          * method that returns true when the 
          * contents of 2 LList2 objects are the same (the two objects in 
          * this case are the current object and other). Note that 2 LList2 
          * objects are the same if they have the same number of items and 
          * each item in one object exists in the same location in the other 
          * object.
          */
	public boolean equals(Object other) {
            // Not sure whether to assume other is in fact an
            // instance of LList2. This would be an interesting 
            // case to look at.
            LList2 list2 = (LList2) other;
            
            assert (this.numberOfEntries == list2.numberOfEntries);
            Node currentNode = firstNode;
            
            int index = 0;
            
            while (index < this.numberOfEntries){
		if (this.getEntry(index) == list2.getEntry(index)) {
                    index++;
                } else {
                    return false;
                }
            }
            return true;
	}
	
	/** boolean contains2(T anEntry) 
          * that calls a private recursive method 
          * private boolean contains(T anEntry, Node startNode)
          * that returns whether the list that starts at startNode contains the 
          * entry anEntry.
          */
	boolean contains2(T anEntry) {
            
            Node currentNode = firstNode;
            
            return contains(anEntry, currentNode);
	}
        
	private boolean contains(T anEntry, Node startNode) {
            
            if (startNode.getNextNode() != null) {
                if (startNode.getData() == anEntry) {
                    return true;
                } else {
                    return contains(anEntry, startNode.getNextNode());
                }
            }
            return false;
	}
	
	
	private class Node 
	{
		private T data;  // data portion
		private Node next;  // next to next node

		private Node(T dataPortion)//  PRIVATE or PUBLIC is OK
		{
			data = dataPortion;
			next = null;	
		} // end constructor

		private Node(T dataPortion, Node nextNode)//  PRIVATE or PUBLIC is OK
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor

		private T getData()
		{
			return data;
		} // end getData
		
		private void setData(T newData)
		{
			data = newData;
		} // end setData
		
		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end LList2

