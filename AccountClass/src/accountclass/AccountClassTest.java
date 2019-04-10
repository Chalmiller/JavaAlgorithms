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
public class AccountClassTest {
    
    public static void main(String[] args) {
        AccountClass accountClass = new AccountClass(20.00);
        
        double bal;
        double secondVal;
        // test if clause of debit method
        accountClass.debit(10.00);
        bal = accountClass.getBalance();
        System.out.printf("Balance: %f\n", bal);
        // test else clause of debit method
        accountClass.debit(30.00);
        accountClass.getBalance();
        secondVal = accountClass.getBalance();
        System.out.printf("Balance: %f\n", secondVal);       
    }
}
