
package test;

import java.util.Scanner; // program uses class Scanner

/**
 * Java Problem 2.34
 * Christopher Miller
 * 09-09-18
 */
public class Test {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Population = 7.442 billion
        // Annual Population growth = 1.2% annual change (2016)
        
        Scanner input = new Scanner( System.in );
        
        float curr_pop; // first number to compare
        float pop_total = 0;
        float growth_rate;
        
        System.out.println("Current Population: ");
        curr_pop = input.nextFloat();
        System.out.println("Current Growth Rate: ");
        growth_rate = input.nextFloat();
       
        population_calculator(curr_pop, growth_rate);
    }
    
    private static void population_calculator(float pop, float growth) {
        
        // Population = 7.442 billion
        // Annual Population growth = 1.2% annual change (2016)
        
        float pop_total = pop;
        float growth_int = growth/100;
        
        System.out.printf("%f \n", pop_total); // Print intial population
        
        for (int year = 1; year <= 5; year++) {
            pop_total = pop_total + (pop_total * growth_int);
            System.out.printf("Year %d population total (in billions): "
                    + "%f \n", year, pop_total);
        }
    }
}

