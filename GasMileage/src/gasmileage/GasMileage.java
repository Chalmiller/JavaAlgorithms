/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasmileage;

import java.util.Scanner; 

/**
 *
 * @author Chris
 */
public class GasMileage {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int milesDriven;
        int gallonsUsed;
        int milesPerGallon;
        int trips = 0; 
        
        int combinedData = 0;
        
        System.out.println("Enter miles (-1 to quit): \n");
        milesDriven = scanner.nextInt();
        
        while (milesDriven != -1) {
            
            System.out.println("Enter gallons: \n");
            gallonsUsed = scanner.nextInt();
            
            milesPerGallon = milesPerGallon(milesDriven, gallonsUsed);
            System.out.printf("MPG this tankful: %d\n", milesPerGallon);
            
            trips += 1;
            
            combinedData += milesPerGallon(milesDriven, gallonsUsed)/trips;
            System.out.printf("Total MPG: %d\n", combinedData);
            
            System.out.println("Enter miles (-1 to quit): \n");
            milesDriven = scanner.nextInt();
        } 
    }
    
    public static int milesPerGallon(int miles, int gallons) {
        return miles/gallons;
    }  
}
