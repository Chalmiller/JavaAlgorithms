/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradebook;

/**
 *
 * @author Chris
 */
public class GradeBook {
    
    private String courseName;
    private String instructorName;
    
    public GradeBook( String name, String instructName ) {
        courseName = name;
        instructorName = instructName;
    }

    public void setCourseName( String name ) {
        courseName = name;
    }
    
    public void setInstructorName( String name ) {
        instructorName = name;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public String getInstructorName() {
        return instructorName;
    }
    
    public void displayMessage() {
        System.out.printf("Welcome to the grade book for %s!\n", getCourseName());
        System.out.printf("This course is presented by %s!\n", getInstructorName());
    }
}
