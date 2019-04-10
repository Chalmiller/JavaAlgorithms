/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computepay;

/**
 *
 * @author Chris
 */
public class ComputePay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(computePay(39));
        System.out.println(computeSavings(39, 1));
    }
    
    public static long computePay(int n) {
        
        if (n == 1) {
            return 1;
        } else {
            return computePay(n-1)*2;
        }
    }
    
    public static long computeSavings(int n, long savings) {
        
        if (n == 1) {
            return savings;
        } else {
            return savings += computeSavings(n-1, savings)*2;
            
        }
    }
}
