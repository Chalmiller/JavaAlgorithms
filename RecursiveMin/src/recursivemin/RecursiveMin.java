/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivemin;

/**
 *
 * @author Chris
 */
public class RecursiveMin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [] a = new int [] {2,3,5,7,11,13,17,19,47,53,59,61,67,71,73,79,83,89,97,23,29,31,37,41,43};
        int result = RecursiveMin.arrayMin(a, 0, 24);
        
        System.out.println(result);
    }
    
    public static int arrayMin(int [] a,int first,int last) {
        
        int mid;
        
        if (first == last) {
            return a[first];
        } else {
            mid = (first + last)/2;
            int a1 = arrayMin(a, first, mid);
            int a2 = arrayMin(a, mid + 1, last);
            
            return (a1 < a2) ? a1 : a2;
        }
    }   
}
