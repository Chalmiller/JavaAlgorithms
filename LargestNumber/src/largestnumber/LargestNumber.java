/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestnumber;
import java.util.Scanner; 

/**
 *
 * @author Chris
 */
public class LargestNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        int number = 0;
        int largest = 0;
        
        while(counter < 10) {
            System.out.println("Please enter a number: \n");
            number = scanner.nextInt();
            
            if (number > largest) {
                largest = number;
                counter += 1;
            } else {
                counter += 1;
            }
        }
        System.out.printf("The largest number in the series is: %d \n", largest);
    }
}
