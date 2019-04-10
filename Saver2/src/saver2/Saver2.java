/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saver2;

// Exercise 15.19 Solution: Saver2.java
// Program simulates a simple screen saver
import javax.swing.JFrame;

public class Saver2
{
   public static void main( String args[] )
   {
        JFrame frame = new JFrame( "Screen Saver" );
      
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 
        SaverJPanel saverjpanel = new SaverJPanel();
      
        frame.add(saverjpanel); // add panel to frame
        frame.setSize(300, 300);
        frame.setVisible( true );
   } // end main
} // end class Saver2


