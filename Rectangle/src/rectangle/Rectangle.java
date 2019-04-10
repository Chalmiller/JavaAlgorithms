/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangle;

// Exercise 8.4 Template: Rectangle.java
// Definition of class Rectangle

public class Rectangle
{
// Instance Variables
	// the length of the rectangle
	// the width of the rectangle
    private double recLength;
    private double recWidth;
	
// Constructor
   // constructor without parameters public Rectangle(), note default length=1.0, width=1.0
    public Rectangle() {
        this.recLength = 1.0;
        this.recWidth = 1.0;
    }
   // constructor with length and width supplied public Rectangle( ..., ...)
    public Rectangle(double len, double wid) {
        this.recLength = len;
        this.recWidth = wid;
    }
   
// Methods
   // validate and set length
    public void setLength(double len){
        if (len > 0) {
            this.recLength = len;
        } else {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
    }
   // validate and set width 
    public void setWidth(double wid){
        if (wid > 0) {
            this.recWidth = wid;
        } else {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
    }
   // get value of length
    public double getLength(){
        return recLength;
    }
   // get value of width
    public double getWidth(){
        return recWidth;
    }
   // calculate rectangle's perimeter
    public double recPerimeter(double len, double wid){
        double perimeter;
        
        perimeter = 2*(len + wid);
        
        return perimeter;
    }
   // calculate rectangle's area
    public double recArea(double len, double wid){
        double area;
        
        area = len*wid;
        
        return area;
    }
   // display info about the rectangle, width, length, perimeter and area.
    public void displayAll() {
        System.out.printf("Length: %.6f\n", this.recLength);
        System.out.printf("Width: %.6f\n", this.recWidth);
        System.out.printf("Perimeter: %.6f\n", recPerimeter(this.recLength,this.recWidth));
        System.out.printf("Area: %.6f\n", recArea(this.recLength,this.recWidth));
    }

} // end class Rectangle
