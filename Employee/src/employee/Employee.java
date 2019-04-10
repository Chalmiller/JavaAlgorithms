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
public class Employee {

    private String firstName;
    private String lastName;
    private double monthlySalary;
    
    public Employee(String first, String last, double salary) {
        firstName = first;
        lastName = last;
        monthlySalary = salary;
    }
    // setters
    public void setFirstName( String first ) {
        firstName = first;
    }
    public void setLastName( String last ) {
        lastName = last;
    }
    public void setSalary( double salary ) {
        
        if (salary > 0) {
            monthlySalary = salary;
        } else {
            monthlySalary = monthlySalary;
        }
    }
    // getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public double getSalary() {
        return monthlySalary;
    }
    
}
