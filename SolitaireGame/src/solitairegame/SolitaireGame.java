/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitairegame;

import java.util.ListIterator;
import java.util.Random;

/**
   A solitaire matching game in which you have a list of random
   integer values between 10 and 99. You remove from the list any
   pair of consecutive integers whose first or second digits match.
   If all values are removed, you win.

 */
public class SolitaireGame
{
	/** Initializes the list with 40 random 2 digit numbers. */
	public static void initializeList(ArrayListWithListIterator<Integer> theList)
	{   
            Random r = new Random();
            int Low = 10;
            int High = 100;            
            
            ListIterator<Integer> myListIterator = theList.getIterator();
            
            for(int num = 1; num <= 40; num++) {
                int Result = r.nextInt(High-Low) + Low;
                myListIterator.add(Result);
            }
	} // end initializeList

	/** Sees whether two numbers are removable.
		@param x  The first 2 digit integer value.
		@param y  The second 2 digit integer value.
 		@return  True if x and y match in the first or second digit. */
	public static boolean removable(Integer x, Integer y)
	{   
            boolean isMatch = false;
            
            if (x/10 == y/10 || x%10 == y%10) {
                isMatch = true;
            } 
            
            return isMatch;
	} // end removable

	/** Display the contents of theList using a ListIterator
	 * 
	 */
	public static void displayList(ArrayListWithListIterator<Integer> theList) 
	{
            ListIterator<Integer> myListIterator = theList.getIterator();
            
            while(myListIterator.hasNext()){
                int next = myListIterator.next();
                System.out.printf("%d ",next);
            }
	}
	/** Scans over the list and removes any pairs of values that are removable.
		@param theList  The list of 2 digit integers to scan over.
		@return  True if any pair of integers was removed. */
	public static boolean scanAndRemovePairs(ArrayListWithListIterator<Integer> theList)
	{
            ListIterator<Integer> myListIterator = theList.getIterator();
            boolean hasRemoved = false;
            
            while(myListIterator.hasNext()){
                int next = myListIterator.nextIndex();
                int nextInt = myListIterator.next();
                if (next == 0) {
                    if(removable(theList.getEntry(next+1),theList.getEntry(next+2))) {
                        int removed2 = nextInt;
                        int removed1 = theList.getEntry(next+2);
                        myListIterator.remove();
                        theList.remove(next+2);
                        System.out.printf("\nRemoved: %d %d", removed1, removed2);
                        System.out.println("\nThe list is now: ");
                        displayList(theList);
                        hasRemoved = true;
                    } 
                } else {
                    if (next == theList.getLength() - 1) {
                        return hasRemoved;
                    } else {
                        if(removable(theList.getEntry(next),theList.getEntry(next+1))) {
                            int removed2 = nextInt;
                            int removed1 = theList.getEntry(next);
                            System.out.printf("\nRemoved: %d %d", removed1, removed2);
                            myListIterator.remove();
                            theList.remove(next);
                            hasRemoved = true;
                            System.out.println("\nThe list is now: ");
                            displayList(theList);
                        }
                    }
                }
            }
            return hasRemoved;
	} // end scanAndRemovePairs

	public static void main(String args[])
	{
            ArrayListWithListIterator<Integer> myList = new ArrayListWithListIterator<Integer>();
            initializeList(myList);
            
            System.out.println("The list is originally: ");
            displayList(myList);
            
            boolean listCont = scanAndRemovePairs(myList);
            
            while (listCont && myList.isEmpty() != true) {
                listCont = scanAndRemovePairs(myList);
            }
            System.out.print("\nNo more pairs to remove.");
	} // end main
} // end SolitaireGame

/*
Example outupt
The list is originally: [81, 50, 11, 61, 42, 74, 16, 65, 49, 49, 11, 19, 67, 79, 33, 95, 85, 52, 59, 67, 46, 81, 62, 30, 60, 66, 80, 96, 30, 81, 37, 30, 34, 30, 15, 80, 11, 61, 55, 46]
   Removed: 11  61
   Removed: 49  49
   Removed: 11  19
   Removed: 95  85
   Removed: 52  59
   Removed: 30  60
   Removed: 37  30
   Removed: 34  30
   Removed: 11  61
The list is now: [81, 50, 42, 74, 16, 65, 67, 79, 33, 67, 46, 81, 62, 66, 80, 96, 30, 81, 15, 80, 55, 46]
   Removed: 65  67
   Removed: 62  66
The list is now: [81, 50, 42, 74, 16, 79, 33, 67, 46, 81, 80, 96, 30, 81, 15, 80, 55, 46]
   Removed: 81  80
The list is now: [81, 50, 42, 74, 16, 79, 33, 67, 46, 96, 30, 81, 15, 80, 55, 46]
   Removed: 46  96
The list is now: [81, 50, 42, 74, 16, 79, 33, 67, 30, 81, 15, 80, 55, 46]
No more pairs to remove.

 */
