/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salarycalculator;

import java.util.Scanner; 

/**
 *
 * @author Chris
 */
public class SalaryCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int hoursWorked;
        double hourlyRate;
        double gross;
        int employees;
        
        for (int i = 1; i <= 3; ++i ) {
            System.out.printf("Enter hours worked: \n", i);
            hoursWorked = scanner.nextInt();
            System.out.printf("Enter hourly rate: \n", i);
            hourlyRate = scanner.nextDouble();
            
            gross = grossPay(hoursWorked, hourlyRate);
            System.out.printf("Pay for employee %d is: $%.2f\n", i, gross);
        }        
    }
    
    public static double grossPay(int hours, double hourlyRate) {
        
        double grossPayed = 0;
        double overTimePay = 0;
        double overTimeAccrued;
        
        if (hours <= 40) {
            grossPayed = hours * hourlyRate;
        } else if (hours > 40) {
            overTimePay = hourlyRate + (hourlyRate*0.5);
            overTimeAccrued = hours - 40;
            grossPayed = (40 * hourlyRate) + (overTimeAccrued * overTimePay);
        }
        
        return grossPayed;
    }
}
