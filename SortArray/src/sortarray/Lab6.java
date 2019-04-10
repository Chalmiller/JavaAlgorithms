/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortarray;

import java.util.*;
import java.util.Arrays;

public class Lab6 {
	// Problem 1
public static <T extends Comparable<? super T>> boolean inArrayIterativeSorted(T[] anArray, T anEntry) {
		
    boolean match;
    int first = 0;
    int last = anArray.length - 1;
    int mid = first + (last - first) / 2;
    
    if(first > last) {
        match = false;
    } else if (anEntry.equals(anArray[mid])) {
         match = true;
    } else if(anEntry.compareTo(anArray[mid]) < 0) {
        mid = mid-1;
        T[] newArray = Arrays.copyOfRange(anArray, first, mid);
        match = inArrayIterativeSorted(newArray, anEntry);
    } else {
        mid = mid + 1;
        T[] newArray = Arrays.copyOfRange(anArray, first, mid);
        match = inArrayIterativeSorted(newArray, anEntry);
    }
    return match;
}
	
// Problem 2
public static <T extends Comparable<? super T>> Interval findInterval(T[] sortedData, List<T> targetValues){
    
    Interval interval = new Interval();
    
    int upper = interval.getUpper(sortedData, targetValues);
    int lower = interval.getLower(sortedData, targetValues);
    
    System.out.printf("The range is %d to %d\n", lower, upper);
    
    return interval;
}
	// Problem 3
public static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
    
    boolean sorted = false;
    
    for(int index = 0; index < a.length; index++) {
        if (a[index].compareTo(a[index]) >= 0) {
            sorted = true;
        } else {
            return false;
        }
    }
    return sorted;
}
	
	// Problem 4
public static <T extends Comparable<? super T>> void modifiedSelectionSort(T[] a, int n) {
	  
        for (int i = 0; i < n-1; i++) 
        { 
            int min_idx = i; 
            int max_idx = i + 1;
            for (int j = i+1; j < n; j++) 
                if (a[j].compareTo(a[min_idx]) < 0) 
                    min_idx = j; 
                else if (a[j].compareTo(a[min_idx]) >= 0) {
                    max_idx = j;
                }
            T temp = a[min_idx]; 
            a[min_idx] = a[max_idx]; 
            a[max_idx] = temp; 
        } 
        
        for (int idx = 0; idx < a.length; idx++) {
            System.out.println(a[idx]);
        }
    }

public static void main(String [] args) {
	Integer [] a = {5,8,10,13,15,20,26};
        List<Integer> list = new ArrayList<Integer>();
        list.add(8);
        list.add(2);
        list.add(9);
        list.add(17);
        // test intArrayIterativeSorted
        boolean match = inArrayIterativeSorted(a, 10);
	System.out.println(match);
//        
        // test isSorted()
        boolean sorted = isSorted(a);
        System.out.println(sorted);
        
        // test modifiedSelectionSort()
        modifiedSelectionSort(a, 7);
        
        // test findInterval()
        findInterval(a, list);
    }
}


