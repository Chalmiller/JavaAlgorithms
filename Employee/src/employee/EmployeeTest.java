/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

/**
 *
 * @author Chris
 */
public class EmployeeTest {
    
    public static void main(String[] args) {
        Employee employee_1 = new Employee("Chris", "Miller", 200000.00);
        Employee employee_2 = new Employee("Jackie", "Baca", 100000.00);
        
        String first_1 = employee_1.getFirstName();
        System.out.printf("firstName: %s\n", first_1);
        String last_1 = employee_1.getLastName();
        System.out.printf("lastName: %s\n", last_1);        
        double salary_1 = employee_1.getSalary();
        System.out.printf("Salary: %s\n", salary_1);
        
        String first_2 = employee_2.getFirstName();
        System.out.printf("firstName: %s\n", first_2);
        String last_2 = employee_2.getLastName();
        System.out.printf("lastName: %s\n", last_2);        
        double salary_2 = employee_2.getSalary();
        System.out.printf("Salary: %s\n", salary_2);
        
        
        employee_1.setSalary(220000); 
        double raise_1 = employee_1.getSalary();
        System.out.printf("Salary after raise: %s\n", raise_1);
        employee_2.setSalary(110000);
        double raise_2 = employee_2.getSalary();
        System.out.printf("Salary after raise: %s\n", raise_2);
    } 
}