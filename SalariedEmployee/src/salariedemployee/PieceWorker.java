/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salariedemployee;

/**
 *
 * @author Chris
 */
public class PieceWorker extends Employee {
    private double wage;
    private double pieces;
    
    // constructor
   public PieceWorker(String firstName, String lastName,
      String socialSecurityNumber, Date birthDate, double wage, double pieces) {
      super(firstName, lastName, socialSecurityNumber, birthDate);

      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Piece wage must be >= 0.0");
      }

      this.wage = wage;
      this.pieces = pieces;
   } 

   // set wage
   public void setWage(int wage) {
      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Wage per piece must be >= 0.0");
      }

      this.wage = wage;
   } 

   // return wage
   public double getWage() {return wage;}

   // set pieces produced
   public void setPieces(int pieces) {
      if (pieces < 0) { // validate hours
         throw new IllegalArgumentException(
            "Pieces produced must be greater than >= 0");
      }

      this.pieces = pieces;
   } 

   // return hours worked
   public double getPieces() {return pieces;}

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings() {                                                                                                    
         return getWage() * getPieces();                                                             
   }                                                                   

   // return String representation of PieceWorker object              
   @Override                                                             
   public String toString() {                                            
      return String.format("Piece Worker: %s%n%s: $%,.2f; %s: %,.2f", 
         super.toString(), "Piece wage", getWage(),                     
         "Pieces created", getPieces());                                    
   }                                                   
}
