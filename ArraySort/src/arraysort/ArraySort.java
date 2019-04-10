/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysort;

public class ArraySort
{
    public static <T extends Comparable<? super T>>
			     void mergeSort(T[] a, int n) {
		mergeSort(a, 0, n - 1);
    } 

    public static <T extends Comparable<? super T>>
			     void mergeSort(T[] a, int first, int last) {
		@SuppressWarnings("unchecked")
	    T[] tempArray = (T[])new Comparable<?>[a.length];
	    mergeSort(a, tempArray, first, last);
    } 
	
    private static <T extends Comparable<? super T>>
			      void mergeSort(T[] a, T[] tempArray, int first, int last)
    {
		if (first < last) {  // sort each half
			int mid = (first + last) / 2;// index of midpoint
			mergeSort(a, first, mid);  // sort left half array[first..mid]
			mergeSort(a, mid + 1, last); // sort right half array[mid+1..last]
	    
			if (a[mid].compareTo(a[mid + 1]) > 0)     
				merge(a, tempArray, first, mid, last); // merge the two halves
			//	else skip merge step
		} 
    } 
    
    private static <T extends Comparable<? super T>> 
			      void merge(T[] a, T[] tempArray, int first, int mid, int last)
    {
		// Two adjacent subarrays are a[beginHalf1..endHalf1] and a[beginHalf2..endHalf2].
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;
	
		// while both subarrays are not empty, copy the
		// smaller item into the temporary array
		int index = beginHalf1; // next available location in
		// tempArray
		for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++) {  
	    
			if (a[beginHalf1].compareTo(a[beginHalf2]) < 0) {  
				tempArray[index] = a[beginHalf1];
				beginHalf1++;
			}
			else {  
				tempArray[index] = a[beginHalf2];
				beginHalf2++;
			}  
		}  
	
		// finish off the nonempty subarray
	
		// finish off the first subarray, if necessary
		for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
			tempArray[index] = a[beginHalf1];
	
		// finish off the second subarray, if necessary
		for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
			tempArray[index] = a[beginHalf2];
	
		// copy the result back into the original array
		for (index = first; index <= last; index++)
			a[index] = tempArray[index];
	}  
    
    // Quick Sort
    
    // Median-of-three privot selection
    // Sort by comparison
    private static <T extends Comparable<? super T>>
			      void sortFirstMiddleLast(T[] a, int first, int mid, int last)
    {
		// Note similarity to bubble sort
		order(a, first, mid); // make a[first] <= a[mid]
		order(a, mid, last);  // make a[mid] <= a[last]
		order(a, first, mid); // make a[first] <= a[mid]
    } 

    private static <T extends Comparable<? super T>>
			      void order(T[] a, int i, int j)
    {
		if (a[i].compareTo(a[j]) > 0)
			swap(a, i, j);
    } 
    
    public static void swap(int[] arrA, int a, int b) {
		int x = arrA[a];
		arrA[a] = arrA[b];
		arrA[b] = x;
}
    
    // Partitioning
    
    private static <T extends Comparable<? super T>>
			      int partition(T[] a, int first, int last)
    {
		int mid = (first + last)/2;
		sortFirstMiddleLast(a, first, mid, last);

		// move pivot to next-to-last position in array
		swap(a, mid, last - 1);
		int pivotIndex = last - 1;
		T pivot = a[pivotIndex];

		// determine subarrays Smaller = a[first..endSmaller]
		// and                 Larger  = a[endSmaller+1..last-1]
		// such that entries in Smaller are <= pivot and 
		// entries in Larger are >= pivot; initially, these subarrays are empty
	
		int indexFromLeft = first + 1; 
		int indexFromRight = last - 2;
	
		boolean done = false;
		while (!done) {
			// starting at beginning of array, leave entries that are < pivot;
			// locate first entry that is >= pivot; you will find one,
			// since last entry is >= pivot
			while (a[indexFromLeft].compareTo(pivot) < 0)
				indexFromLeft++;
			
			// starting at end of array, leave entries that are > pivot; 
			// locate first entry that is <= pivot; you will find one, 
			// since first entry is <= pivot
			
			while (a[indexFromRight].compareTo(pivot) > 0)
				indexFromRight--;
					   
			if (indexFromLeft < indexFromRight)
			{
				swap(a, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			}
			else 
				done = true;
		} // end while
	
		// place pivot between Smaller and Larger subarrays
		swap(a, pivotIndex, indexFromLeft);
		pivotIndex = indexFromLeft;
		
		return pivotIndex; 
    } 
    public static <T extends Comparable<? super T>>
			     void quickSort(T[] a, int n) {
		quickSort(a, 0, n - 1);
    } 
    
    public static <T extends Comparable<? super T>>
			     void quickSort(T[] a, int first, int last) {
		// perform recursive step if 2 or more elements
		if(first < last) {
			// create the partition: Smaller | Pivot | Larger
			int pivotIndex = partition(a, first, last);
			
			// sort subarrays Smaller and Larger
			quickSort(a, first, pivotIndex - 1);
			quickSort(a, pivotIndex + 1, last);
		} 
    }
                             
    public static int findMissing(int [] a) {
        
        int lenArray = a.length + 1;
        int sumOfLen = lenArray*(lenArray + 1)/2;
        int actualSum = 0;
        int missingNum = 0;
        
        for (int num = 0; num < a.length; num++) {
            actualSum += a[num];
        }
        missingNum = sumOfLen - actualSum;
        return missingNum;
    }
    
    public static void countingSort(int [] arr, int n) {
        
        int len = arr.length; 
  
        int[] output = new int[len]; 
        int count[] = new int[256]; 
        
        for (int i=0; i<256; ++i) {
            count[i] = 0; 
        }
        
        for (int i=0; i<len; ++i) {
            ++count[arr[i]]; 
        }
        
        for (int i=1; i<=255; ++i) {
            count[i] += count[i-1]; 
        }
        
        for (int i = len-1; i>=0; i--) { 
            output[count[arr[i]]-1] = arr[i]; 
            --count[arr[i]]; 
        } 
  
        for (int i = 0; i < len; ++i) {
            arr[i] = output[i];
            System.out.printf("The Counting Sort Method returns: %d\n", arr[i]);
        }        
    }
    
    public static int findKSmallest(int[] arrA, int k) {
            k = k - 1; // since array index starts with 0
            return kSmall(arrA, 0, arrA.length - 1, k);
    }

    public static int kSmall(int[] arrA, int start, int end, int k) {
        int left = start;
        int right = end;
        int pivot = start;
        while (left <= right) {
                while (left <= right && arrA[left] <= arrA[pivot])
                        left++;
                while (left <= right && arrA[right] >= arrA[pivot])
                        right--;
                if (left < right) {
                        swap(arrA, left, right);
                        left++;
                        right--;
                }
        }
        swap(arrA, pivot, right);
        if (pivot == k)
                return arrA[pivot];// if pivot is kth element , return
        else if (pivot < k)
                // if pivot is less than k, then kth element will be on the right
                return kSmall(arrA, pivot + 1, end, k);
        else
                // if pivot is greater than k, then kth element will be on the right
                return kSmall(arrA, start, pivot - 1, k);
    }
    
    public static int findMedian(int[] a) {
        
        int k = (a.length)/2;
        
        int median = findKSmallest(a, k);
        
        return median;
    }
    
    public static void main(String[] args) {
        int [] A1 = {3,6,5,1,4};
        int [] A2 = {9, 2, 4, 8, 9, 4, 3, 2, 8, 1, 2, 7, 2, 5};
        int [] A3 = {4,7,5,2,6,1,3};
        
        System.out.printf("findMissing Result: %d\n", findMissing(A1));
        System.out.print("Counting Sort efficiency is O(n)\n");
        countingSort(A2, 9);
        System.out.printf("The median of your list is: %d\n", findMedian(A3));
    }
}
