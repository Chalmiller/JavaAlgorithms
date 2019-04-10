/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savingsaccount;

// Exercise 8.6 Template: SavingsAccountTest.java
// Program that tests SavingsAccount class

public class SavingsAccountTest
{
   public static void main( String[] args )
   {
        // create new SavingsAccount saver1 with $2000 balance
	// create new SavingsAccount saver2 with $3000 balance
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);
	  
	//Set annual interest rate to 4%
        SavingsAccount.modifyInterestRate(.04);
        
        System.out.print("\t\tSaver 1\t\t\tSaver 2\n");
	// Loop through 12 months
        for(int mon = 1; mon <= 12; mon++){
            System.out.printf("Month %d:\t$%.2f\t\t$%.2f\n", mon, saver1.calculateMonthlyInterest(), saver2.calculateMonthlyInterest());
        }
        System.out.print("\nSaver 1\t\tSaver 2\n");
        SavingsAccount.modifyInterestRate(.05);
	System.out.printf("$%.2f\t$%.2f\n", saver1.calculateMonthlyInterest(), saver2.calculateMonthlyInterest());
   } // end main
} // end class SavingsAccountTest
