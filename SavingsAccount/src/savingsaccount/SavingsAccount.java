/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savingsaccount;

// Exercise 8.6 Solution: SavingAccount
// SavingAccount class definition

public class SavingsAccount
{
//Instance Variables
	// interest rate for all accounts, hint: static
	// balance for currrent account
    static double annualInterestRate;
    private double savingsBalance;

// constructor
	// creates a new account with the specified balance
    public SavingsAccount(double bal){
        this.savingsBalance = bal;
    }

// methods
   // get account balance
    public double getBalance(){
        return savingsBalance;
    }
   // calculate monthly interest, hint: need to update the balance
    public double calculateMonthlyInterest() {
        this.savingsBalance += (annualInterestRate*this.getBalance())/12.0;
        return savingsBalance;
    }
   // modify interest rate, hint: static
    public static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate;
    }
   // display account info with balance
    public void displayAccountInfo(){
        System.out.printf("%.2f", this.getBalance());
    }
   
} // end class SavingsAccount
