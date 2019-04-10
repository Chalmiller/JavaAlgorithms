/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangle;

import java.util.Scanner;

// Exercise 8.4 Template: RectangleTest.java
// Program tests class Rectangle.

public class RectangleTest
{
   public static void main( String[] args )
	{   
            Scanner scanner = new Scanner(System.in);
            Rectangle rectangle = new Rectangle();
            
            int choice;
            double clientLength;
            double clientWidth;
            
            System.out.print("1. Set Length\n2. Set Width\n3. Exit");
            System.out.print("\nChoice: ");
            
            choice = scanner.nextInt();
            
            while(choice!=3){
                if (choice == 1) {
                    System.out.print("\nEnter Length: ");
                    clientLength = scanner.nextDouble();
                    rectangle.setLength(clientLength);
                    rectangle.displayAll();
                    System.out.print("\nChoice: "); 
                    choice = scanner.nextInt();
                } else if(choice == 2) {
                    System.out.print("\nEnter Width: ");
                    clientWidth = scanner.nextDouble();
                    rectangle.setWidth(clientWidth);
                    rectangle.displayAll();
                    System.out.print("\nChoice: "); 
                    choice = scanner.nextInt();
                } 
            }
   	}
} // end class RectangleTest
