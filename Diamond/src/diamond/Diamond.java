/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diamond;

import java.util.Scanner;
/**
 *
 * @author Chris
 */
public class Diamond {
 
    public static void main(String[] args) {

        for(int i=1;i<=5;i++) {
            for(int j=1;j<=5-i;j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=i*2-1;j++) {
                System.out.print("*");
            }

            System.out.println();
        } 

        for(int i=5-1;i>0;i--) {
            for(int j=1;j<=5-i;j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=i*2-1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
