/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printleapyear;

/**
 *
 * @author Chris
 */
public class PrintLeapYear {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
    }
    
    public static boolean isLeapYear(int year) {
        boolean isLeap = false;
        
        isLeap = ((year%4 ==0 && year%100 == 0)) || year%400 == 0;
        
        return isLeap;
    }
    
}
