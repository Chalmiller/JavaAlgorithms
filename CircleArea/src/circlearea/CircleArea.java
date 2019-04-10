/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlearea;

import java.util.Scanner; 

/**
 *
 * @author Chris
 */
public class CircleArea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        double r;
        
        System.out.print("Enter the radius (negative to quit): ");
        r = scanner.nextInt();
        
        while (r >= 0 ) {
            System.out.println(circleArea(r));
            System.out.print("Enter the radius (negative to quit): ");
            r = scanner.nextInt();
        }   
    }
    
    public static double circleArea(double radius) {
        
        double area = Math.PI * (radius * radius);
        
        return area;
    }
}
