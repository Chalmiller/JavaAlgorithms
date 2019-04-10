/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.Arrays;
public class MaxHeap< T extends Comparable < ? super T >> implements MaxHeapInterface 
{
    private T [] heap; // array of heap entries
    private int lastIndex; // index of last entry
    private static final int DEFAULT_INITIAL_CAPACITY = 25;
    public MaxHeap () {
        this (DEFAULT_INITIAL_CAPACITY); // call next constructor
    } // end default constructor


    public MaxHeap (int initialCapacity) {
        // the cast is safe because the new array contains all null entries
        @ SuppressWarnings ("unchecked")
            T [] tempHeap = (T []) new Comparable [initialCapacity + 1];
        heap = tempHeap;
        lastIndex = 0;
    } // end constructor
    

    public void add (T newEntry) {
        lastIndex++;
        ensureCapacity ();
        int newIndex = lastIndex;
        int parentIndex = newIndex / 2;
        while ((parentIndex > 0) && newEntry.compareTo (heap [parentIndex]) > 0) {
            heap [newIndex] = heap [parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        } // end while
        heap [newIndex] = newEntry;
    } // end add
    

    public T removeMax () {
        T root = null;
        if (!isEmpty ()) {
	    root = heap [1]; // return value
            heap [1] = heap [lastIndex]; // form a semiheap
            lastIndex--; // decrease size
            reheap (1); // transform to a heap
        } // end if
        return root;
    } // end removeMax
    
    
    public T getMax () {
        T root = null;
        if (!isEmpty ())
            root = heap [1];
        return root;
    } // end getMax

    
    public boolean isEmpty () {
        return lastIndex < 1;
    } // end isEmpty
    

    public int getSize () {
        return lastIndex;
    } // end getSize
    

    public void clear () {
        for (; lastIndex > -1 ; lastIndex--)
            heap [lastIndex] = null;
        lastIndex = 0;
    } // end clear


    // Private methods 
    private void reheap (int rootIndex) {
        boolean done = false;
        T orphan = heap [rootIndex];
        int leftChildIndex = 2 * rootIndex;
        while (!done && (leftChildIndex <= lastIndex))
        {
            int largerChildIndex = leftChildIndex; // assume larger
            int rightChildIndex = leftChildIndex + 1;
            if ((rightChildIndex <= lastIndex) &&
                    heap [rightChildIndex].compareTo (heap [largerChildIndex]) > 0)
            {
                largerChildIndex = rightChildIndex;
            } // end if
            if (orphan.compareTo (heap [largerChildIndex]) < 0)
            {
                heap [rootIndex] = heap [largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }
            else
                done = true;
        } // end while
        heap [rootIndex] = orphan;
    } // end reheap
    
    
    public int findKthSmallest(int[] arr, int k ) {

        if(k <= 0 || k > arr.length) {
            throw new IllegalArgumentException();
        }

        MaxHeap<Integer> smallestK = new MaxHeap<>(k);

        for(int i = 0; i < k; i++) {
            smallestK.add(arr[i]);
        }

        for(int j = k; j < arr.length; j++) {
            if(arr[j] < smallestK.getMax()) {
                smallestK.removeMax();
                smallestK.add(arr[j]);
            }
        }
        return smallestK.getMax();
    }
    
} // end MaxHeap
