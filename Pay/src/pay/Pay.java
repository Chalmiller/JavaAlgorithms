/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pay;

/**
 *
 * @author Chris
 */
import java.util.Random;

public class Pay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        totalPay(6, false);
        // arbitrary value for days in the second call
        totalPay(7, true);
    }
    
    public static void totalPay(int days, boolean goal) {
        int pay = 0;
        int total = 0;
        
        if (goal == false) {
            System.out.println("Day\tPay\tTotal Earnings");
            for (int i = 1; i <= days; i++) {
                if (i == 1) {
                    pay = 1;
                    total = 1;
                    System.out.printf("%d\t%d\t%d\n", i, pay, total);
                } else {
                    pay *= 2;
                    total += pay;
                    System.out.printf("%d\t%d\t%d\n", i, pay, total);
                }
            }
        } else if (goal == true) {
            Random randomNumber = new Random();
            
            int day = 0;
            int earningGoal = 1 + randomNumber.nextInt(1000);
            
            System.out.printf("Earning Goal: $%d\n", earningGoal);
            
            while(total < earningGoal) {
                if (day == 0) {
                    pay = 1;
                    total = 1;
                    day++; 
                } else {
                    pay *= 2;
                    total += pay;
                    day++;
                } 
            }
            System.out.printf("You need to work %d days to reach the earning goal.\n", day);
        } 
    }
    
}
