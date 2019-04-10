/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oddproduct;

import java.util.Scanner; 

/**
 *
 * @author Chris
 */
public class OddProduct {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int product = 1;
        
        for(int i = 1; i <= 15; i++) {
            if(i%2 == 1) {
                product *= i;
            } else {
                continue;
            }
        }
        
        System.out.println(product);
    }
    
}
