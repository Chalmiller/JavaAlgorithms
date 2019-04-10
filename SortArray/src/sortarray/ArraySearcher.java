/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortarray;


/**
   A class of static methods for searching an array of Comparable objects.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class ArraySearcher
{
   // Segment 18.3
   /** Searches an unsorted array for anEntry. */
   public static <T> boolean inArrayIterativeUnsorted(T[] anArray, T anEntry)
   {
      boolean found = false;
      int index = 0;
      
      while (!found && (index < anArray.length))
      {
         if (anEntry.equals(anArray[index]))
            found = true;
         index++;
      } // end while
      
      return found;
   } // end inArrayIterativeUnsorted
// ========================================================================================
   
   // Segment 18.6
   /** Searches an unsorted array for anEntry. */
   public static <T> boolean inArrayRecursiveUnsorted(T[] anArray, T anEntry)
   {
      return search(anArray, 0, anArray.length - 1, anEntry);
   } // end inArrayRecursiveUnsorted
   
   // Searches anArray[first] through anArray[last] for desiredItem.
   // first >= 0 and < anArray.length.
   // last >= 0 and < anArray.length.
   private static <T> boolean search(T[] anArray, int first, int last, T desiredItem)
   {
      boolean found = false;
      
      if (first > last)
         found = false; // No elements to search
      else if (desiredItem.equals(anArray[first]))
         found = true;
      else
         found = search(anArray, first + 1, last, desiredItem);
      
      return found;
   } // end search
// ========================================================================================

   /** Searches a sorted array for anEntry. */
   public static <T extends Comparable<? super T>> boolean inArrayRecursiveSorted(T[] anArray, T anEntry)
   {
      return binarySearch(anArray, 0, anArray.length - 1, anEntry);
   } // end inArrayRecursiveSorted
   
   // Segment 18.13
   // Searches anArray[first] through anArray[last] for desiredItem.
   // first >= 0 and < anArray.length.
   // last >= 0 and < anArray.length.
   private static <T extends Comparable<? super T>>
           boolean binarySearch(T[] anArray, int first, int last, T desiredItem)
   {
      boolean found;
      int mid = first + (last - first) / 2;
      
      if (first > last)
         found = false;
      else if (desiredItem.equals(anArray[mid]))
         found = true;
      else if (desiredItem.compareTo(anArray[mid]) < 0)
         found = binarySearch(anArray, first, mid - 1, desiredItem);
      else
         found = binarySearch(anArray, mid + 1, last, desiredItem);
         
      return found;
   } // end binarySearch
// ========================================================================================

   public static <T> void display(T[] anArray)
   {
      System.out.print("The array contains the following entries: ");
      for (int index = 0; index < anArray.length; index++)
      {
         System.out.print(anArray[index] + " ");
      } // end for
      
      System.out.println();
   }  // end display
} // end ArraySearcher
