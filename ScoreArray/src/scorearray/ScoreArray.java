/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scorearray;

/**
 *
 * @author Chris
 */

import java.util.Scanner; 

public class ScoreArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        double[] scores = new double[8];
        double highest = 0.00;
        double lowest;
        double total = 0.00;
        double average;
        
        
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scanner.nextInt();
        }
        
        lowest = scores[0];
        highest = scores[0];
        
        for (double value: scores) {
            if (scores[value] >= highest) {
                scores[value] = highest;
            } else if (scores[value] < highest) {
                if (scores[value] <= lowest) {
                    scores[value] = lowest;
                } else {
                    continue;
                }
            }
            total += value;
        } 
        average = total/scores.length;
        
        System.out.printf("Here:%d, %d\n", highest, lowest);
        
        System.out.println(finalScore(scores, highest, lowest, total));
    }  
    
    public static double finalScore(double[] scorz, double high, double low, double total) {
        
        double finalScores;
        double difficultyLevel = 3.4;
        int tot = 0;
        
        for (int hi = 0; hi < scorz.length; hi++) {
            if (scorz[hi] == high) {
                return scorz[hi] = 0;
            }
        }
        for (int lo = 0; lo < scorz.length; lo++) {
            if (scorz[lo] == low) {
                return scorz[lo] = 0;
            }
        }
        for (int val: scorz) {
            tot += val;
        }
        
        return finalScores = (tot/(scorz.length - 2)) * difficultyLevel;
    }
}
