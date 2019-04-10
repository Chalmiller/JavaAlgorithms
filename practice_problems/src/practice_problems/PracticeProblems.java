/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_problems;

/**
 *
 * @author Chris
 */
import java.util.Scanner; 

public class PracticeProblems {
public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in); 
    System.out.println("Hello out there."); 
    System.out.println("Want to talk some more?"); 
    System.out.println("Answer yes or no.");
    String answer = keyboard.next(); 
    
    if (answer.equals("yes"))
        System.out.println("Nice weather we are having.");
        System.out.println("Good-bye.");
    } // end main
} // end FirstProgram
