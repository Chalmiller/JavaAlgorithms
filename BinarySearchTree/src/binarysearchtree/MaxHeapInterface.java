/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

public interface MaxHeapInterface<T extends Comparable<? super T>> {
    public void add (T newEntry);
    public T removeMax ();
    public T getMax ();
    public boolean isEmpty ();
    public int getSize ();
    public void clear ();    
} 