/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountclass;

/**
 *
 * @author Chris
 */
public class AccountClass {

    private double balance;
    
    public AccountClass(double initialBalance) {
        if (initialBalance > 0){
            balance = initialBalance;
        }
    }
    
    public void debit(double amount) {
        if ( amount < balance) {
            balance = balance - amount;
        } else {
            System.out.println("Debit amount exceeded account balance.");
        }
    }
    public void credit(double amount) {
        balance = balance + amount;
    }
    
    public double getBalance() {
        return balance;
    }
}
