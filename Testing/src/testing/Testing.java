/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**
 *
 * @author Chris
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "okay";
        
        T[] array = (T[]) new Object[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            System.out.println(array[i]);
        }
    }
    
}
