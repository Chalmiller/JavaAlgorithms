/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salariedemployee;

public abstract class Employee {
   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;
   private Date birthdate;

   // constructor
   public Employee(String firstName, String lastName, 
      String socialSecurityNumber, Date birthDate) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.socialSecurityNumber = socialSecurityNumber;
      this.birthdate = birthDate;
   } 

   // return first name
   public String getFirstName() {return firstName;}

   // return last name
   public String getLastName() {return lastName;}

   // return social security number
   public String getSocialSecurityNumber() {return socialSecurityNumber;}
   
   public Date getBirthDate() {
       return birthdate;
   }

   // return String representation of Employee object
   @Override
   public String toString() {
      return String.format("%s %s%nsocial security number: %s and birth date: %s", 
         getFirstName(), getLastName(), getSocialSecurityNumber(), getBirthDate());
   }
   
   public void setBirthDate(Date birthDate) {
       this.birthdate = birthDate;
   }
   
   // abstract method must be overridden by concrete subclasses
   public abstract double earnings(); // no implementation here
} 
