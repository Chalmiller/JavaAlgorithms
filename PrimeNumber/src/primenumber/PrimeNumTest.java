/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

/**
 *
 * @author Chris
 */
public class PrimeNumTest {
    
    public static void main(String[] args) {
        PrimeNumber prime = new PrimeNumber();
        
        System.out.println("Prime numbers between 2 and 10000 are: ");
        prime.primenums(10000);
    }
    
}
