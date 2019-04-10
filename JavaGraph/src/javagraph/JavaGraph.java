/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraph;

import java.util.Scanner;

/**
 *
 * @author Chris
 */
public class JavaGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int nums = 0;
        
        for(int i = 0; i < 5; i++) {
            System.out.println("\nEnter number: ");
            int number = scanner.nextInt();
            for (int j = 0; j < number; j++) {
                System.out.print("*");
            }
        }
    } 
}
