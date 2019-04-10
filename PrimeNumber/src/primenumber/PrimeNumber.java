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
public class PrimeNumber {
    
    public static void primenums(int limit) {

        for (int num = 2; num <= limit; num++) {
            if (num == 2 || num == 3 || num == 5 || num == 7) {
                System.out.println(num);
            } else if (num%2 == 0 || num%3 == 0 || num%5 == 0 || num%7 == 0) {
                continue;
            } else {
                System.out.println(num);
            }
        }
    }
}
