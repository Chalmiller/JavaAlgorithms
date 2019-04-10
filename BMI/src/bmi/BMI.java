/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmi;

/**
 *
 * @author Chris
 */
import java.util.Scanner; 

public class BMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int weight;
        int height;
        
        System.out.println("Enter your weight in pounds: ");
        weight = scanner.nextInt();
        
        System.out.println("Enter your height in inches: ");
        height = scanner.nextInt();
        
        System.out.printf("Your BMI is: %.2f\n", calBMI(weight,height));
    }
    
    public static double calBMI(int pounds, int inches) {
        double bmi;
        
        bmi = (pounds*703)/(inches*inches);
        
        return bmi;
    }
}
