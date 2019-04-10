/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraystack2;

/**
    A class of stacks whose entries are stored in an array.
    @author Frank M. Carrano
    @version 3.0
*/
import java.util.Arrays;

public class ArrayStack2<T> implements StackInterface<T>
{
    
    public static void main(String[] args) {
       ArrayStack2 stack_display = new ArrayStack2();
       ArrayStack2 stack_remove_low = new ArrayStack2();
       ArrayStack2 stack_remove_high = new ArrayStack2();
       ArrayStack2 stack_pop = new ArrayStack2();
       
       System.out.println("Test display()");
       stack_display.stack = new Object[] {null};
       stack_display.push(2);
       stack_display.push(3);
       stack_display.push(4);
       stack_display.push(5);
       stack_display.display();
       System.out.println("Test remove() with lower value");
       stack_remove_low.stack = new Object[] {null};
       stack_remove_low.push(2);
       stack_remove_low.push(3);
       stack_remove_low.push(4);
       stack_remove_low.push(5);
       stack_remove_low.remove(1);
       stack_remove_low.display();
       System.out.println("Test remove() with larger value");
       stack_remove_high.stack = new Object[] {null};
       stack_remove_high.push(2);
       stack_remove_high.push(3);
       stack_remove_high.push(4);
       stack_remove_high.push(5);
       stack_remove_high.remove(5);
       stack_remove_high.display();
       System.out.println("Test pop() with isTooBig and reduceArray()");
       stack_pop.stack = new Object[] {null};
       stack_pop.push(2);
       stack_pop.push(3);
       stack_pop.push(4);
       stack_pop.push(5);
       stack_pop.pop();
       
    }
    
   private T[] stack;    // array of stack entries
   private int topIndex; // index of top entry
   private static final int DEFAULT_INITIAL_CAPACITY = 50;
  
   public ArrayStack2()
   {
      this(DEFAULT_INITIAL_CAPACITY);
   } // end default constructor
  
   public ArrayStack2(int initialCapacity)
   {
      // the cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
      topIndex = -1;
  } // end constructor
  
   public void push(T newEntry)   
   {  
       ensureCapacity();      
       topIndex++;      
       stack[topIndex] = newEntry;   
   } // end push   
   
   private void ensureCapacity()   
   {      if (topIndex == stack.length - 1) // if array is full, double size of array      
	   stack = Arrays.copyOf(stack, 2 * stack.length);   
   } // end ensureCapacity
   
   public T peek()   
   {  
       T top = null;         
       if (!isEmpty())       
	   top = stack[topIndex];             
       return top;   
   } // end peek
   
   public T pop()
   {
       T top = null;
       
       if (isTooBig()){
           reduceArray();
       }
       
       if (!isEmpty()) {
	   top = stack[topIndex];
	   stack[topIndex] = null;
	   topIndex--; 
       } // end if
       
       System.out.println(top);
       return top;
   } // end pop
   
   public boolean isEmpty()
   {   
       return topIndex < 0;
   } // end isEmpty

   public void clear()
   {
       for(int i = 0; i <= topIndex; ++i)
	   stack[i] = null;
       topIndex = -1;
   }
   
   public void display() {
        if(isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            for(int i = topIndex; i >= 0; --i) {
                System.out.println(stack[i]);
                stack[i] = null;
            }
       }
   }
   
   public int remove(int n) {
        int return_length;
        
        if(topIndex < n) {
            return_length = topIndex;
            for(int i = 0; i <= topIndex; ++i){
               stack[i] = null;
           }
        } else {
            return_length = n;
            for(int i = topIndex; n > 0; --n){
                stack[i] = null;
                --i;
            }
        } 
        return return_length;
   }
   
   private boolean isTooBig() {
       
       if(topIndex < (stack.length/2) && stack.length > 20) {
           return true;
       } else {
           return false;
       }
   }
   
   private void reduceArray() {
        stack = Arrays.copyOf(stack, 3/4 * stack.length); 
   }
} // end ArrayStack

