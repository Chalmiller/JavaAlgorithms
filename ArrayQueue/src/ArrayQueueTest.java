/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chris
 */
public class ArrayQueueTest {
    
    public static void main(String[] args) {
        ArrayQueue arrayqueue_1 = new ArrayQueue();
        ArrayQueue arrayqueue_2 = new ArrayQueue();
        System.out.println(arrayqueue_1.check("okay, okay"));
        
        arrayqueue_1.enqueue(10);
        arrayqueue_1.enqueue(11);
        arrayqueue_1.enqueue(12);
        
        System.out.println(arrayqueue_1.enqueueNoDuplicate(11));
        
        arrayqueue_2.enqueue(10);
        arrayqueue_2.enqueue(11);
        arrayqueue_2.enqueue(12);
        
        arrayqueue_1.splice(arrayqueue_2);
        
        arrayqueue_1.
    }
    
}
