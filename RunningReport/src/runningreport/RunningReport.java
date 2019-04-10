/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runningreport;

/**
 *
 * @author Chris
 */
import java.util.Scanner;

public class RunningReport {
    
    final static int DEFAULT_DAYS = 7;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] mileLog = new double[DEFAULT_DAYS];
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        double totalMiles = 0;
        int runningDays = 0;
        double average = 0;
        int daysBelowAverage = 0;
        int longestRun = 0;
        String longestRunDay;
        
        for(int days = 0; days < DEFAULT_DAYS; days++) {
            System.out.printf("Enter miles ran on day %d: ", days+1);
            mileLog[days] = scanner.nextDouble();
            totalMiles += mileLog[days];
            if (mileLog[days] != 0) {
                runningDays++;
            }
            if (mileLog[days] > longestRun) {
                longestRun = days;
            }
        }
        longestRunDay = daysOfWeek[longestRun];
        average = totalMiles/(double)runningDays;
        for(double value: mileLog) {
            if (value < average) {
                daysBelowAverage++;
            }
        }
        System.out.printf("Running Days: %d\tTotal miles: %.2f miles\tAverage: %.2f miles/day\n", runningDays, totalMiles, average);
        System.out.printf("Number of days below average: %d\tLongest running day: %s\n", daysBelowAverage, longestRunDay);
        
    }
}
