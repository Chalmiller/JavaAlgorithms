/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

/**
 *
 * @author Chris
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.printf("Factorial of 5 is %d\n", factorial(5));
    }
    
    public static int factorial(int n) {
        
        if(n==0){
            return 1;
        } else {
            return factorial(n-1)*n;
        }
    } 
}
