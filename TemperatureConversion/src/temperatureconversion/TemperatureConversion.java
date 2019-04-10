/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatureconversion;
import java.util.Scanner; 

/**
 *
 * @author Chris
 */
public class TemperatureConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.  Fahrenheit to Celsius");
        System.out.println("2.  Celsius to Fahrenheit");
        System.out.println("3.  Exit");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        int temperature = 0;
        
        while (choice != 3) {
            if (choice == 1) {
                System.out.print("Enter temperature: ");
                temperature = scanner.nextInt();
                System.out.printf("%d Faranheit is %d Celcius\n", temperature, celcius(temperature));
                System.out.println("\n1.  Fahrenheit to Celsius");
                System.out.println("2.  Celsius to Fahrenheit");
                System.out.println("3.  Exit");
                System.out.print("Choice: ");
                choice = scanner.nextInt();
            } else if (choice == 2) {
                System.out.print("Enter temperature: ");
                temperature = scanner.nextInt();
                System.out.printf("%d Celcius is %d Faranheit\n", temperature, faranheit(temperature));
                System.out.println("\n1.  Fahrenheit to Celsius");
                System.out.println("2.  Celsius to Fahrenheit");
                System.out.println("3.  Exit");
                System.out.print("Choice: ");
                choice = scanner.nextInt();
            } 
        } 
    }
    
    public static int celcius(int temp) {
        int temp_c;
        temp_c = (5*(temp-32))/9;
        return temp_c;
    }
    
    public static int faranheit(int temp) {
        int temp_f = temp;
        temp_f = 9/5*temp+32;
        return temp_f;
    }
    
}
