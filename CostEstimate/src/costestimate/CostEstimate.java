/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package costestimate;

/**
 *
 * @author Chris
 */
public class CostEstimate {
    
    private static final double DEFAULT_RENTAL_COST = 100;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Party Size(#people)\tCost Estimate Per Person");
        for(int num = 2; num <= 20; num+=2) {
            System.out.printf("%d\t\t\t%.2f\n", num, cost(num));
        }
        
    }
    
    public static double cost(double numPeople) {
        double perPerson = 0;
        double totalCostPerPerson;
        
        if (numPeople <= 5 && numPeople >= 1) {
            perPerson = 20;
        } else if (numPeople <= 10 && numPeople >= 6) {
            perPerson = 18;
        } else if (numPeople <= 15 && numPeople >= 11) {
            perPerson = 16;
        } else if (numPeople > 15) {
            perPerson = 15;
        }
        
        totalCostPerPerson = perPerson + (DEFAULT_RENTAL_COST/numPeople);
        
        return totalCostPerPerson;
        
    } 
}
