/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salariedemployee;

import java.util.Scanner;

public class PayrollSystemTest {
   public static void main(String[] args) {
      // create subclass objects        
      Date birth1 = new Date(6, 15, 1944);
      Date birth2 = new Date(12, 29, 1960);
      Date birth3 = new Date(9, 8, 1954);
      Date birth4 = new Date(3, 2, 1965);
      Date birth5 = new Date(7, 31, 1989);
      
      Scanner scanner = new Scanner(System.in);
      
      int currentMonth;

      SalariedEmployee salariedEmployee =                                 
         new SalariedEmployee("John", "Smith", "111-11-1111", birth1, 800.00);    
      HourlyEmployee hourlyEmployee =                                     
         new HourlyEmployee("Karen", "Price", "222-22-2222", birth2, 16.75, 40);  
      CommissionEmployee commissionEmployee =                             
         new CommissionEmployee(                                          
         "Sue", "Jones", "333-33-3333", birth3, 10000, .06);                      
      BasePlusCommissionEmployee basePlusCommissionEmployee =             
         new BasePlusCommissionEmployee(                                  
         "Bob", "Lewis", "444-44-4444", birth4, 5000, .04, 300); 
      PieceWorker pieceWorker = new PieceWorker(
              "Chris", "Miller", "555-55-5555", birth5, 20.00, 20.00);

      System.out.println("Employees processed individually:");

      System.out.printf("%n%s%n%s: $%,.2f%n%n", 
         salariedEmployee, "earned", salariedEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n",
         hourlyEmployee, "earned", hourlyEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n",
         commissionEmployee, "earned", commissionEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n", 
         basePlusCommissionEmployee, 
         "earned", basePlusCommissionEmployee.earnings());

      // create four-element Employee array
      Employee[] employees = new Employee[5]; 

      // initialize array with Employees        
      employees[0] = salariedEmployee;          
      employees[1] = hourlyEmployee;            
      employees[2] = commissionEmployee;        
      employees[3] = basePlusCommissionEmployee;
      employees[4] = pieceWorker;

      System.out.printf("Employees processed polymorphically:%n%n");
      
      System.out.print("Enter the current month (1 - 12): ");
      currentMonth = scanner.nextInt();

      // generically process each element in array employees
      for (Employee currentEmployee : employees) {
         System.out.println(currentEmployee); // invokes toString

         // determine whether element is a BasePlusCommissionEmployee
         if (currentEmployee instanceof BasePlusCommissionEmployee) {
            // downcast Employee reference to 
            // BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee employee = 
               (BasePlusCommissionEmployee) currentEmployee;

            employee.setBaseSalary(1.10 * employee.getBaseSalary());

            System.out.printf(
               "new base salary with 10%% increase is: $%,.2f%n",
               employee.getBaseSalary());
         } 
         
         if (currentEmployee.getBirthDate().getMonth() == currentMonth) {
             System.out.printf("earned $%,.2f%n%n\n", currentEmployee.earnings() + 100.00);
         } else {
             System.out.printf("earned $%,.2f%n%n\n", currentEmployee.earnings());
         }

         
      } 

      // get type name of each object in employees array
      for (int j = 0; j < employees.length; j++) {      
         System.out.printf("Employee %d is a %s%n", j,  
            employees[j].getClass().getName());         
      }                                                 
   } 
} 
