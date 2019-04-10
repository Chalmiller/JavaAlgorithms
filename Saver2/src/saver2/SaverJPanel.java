/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saver2;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SaverJPanel extends JPanel implements ActionListener
{
   // random-number generator
   private static final Random random = new Random();
   private Timer timer;

   // constructor sets window's title bar string and dimensions
   public SaverJPanel()
   {
      timer = new Timer( 1000, this ); // create the timer, every 1000 milliseconds, the timer triggers an event on the panel
      timer.start();
   } // end SaverJPanel constructor

   // draw lines 
   public void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        int x, y, x1, y1;

        //TO DO:
	//Use for loop to draw 100 lines
        for (int i = 0; i < 100; i++) {
            //select x, y, x1, y1 coordinates to be random numbers between 0 and 300
            x = random.nextInt(300);
            y = random.nextInt(300);
            x1 = random.nextInt(300);
            y1 = random.nextInt(300);
            //set color to be random RGB value
            g.setColor(new Color(random.nextInt(256),
            random.nextInt(256), random.nextInt(256)));
            g.drawLine(x, y, x1, y1);
        }
   } // end method paintComponent

   // repaint JPanel
   public void actionPerformed( ActionEvent actionEvent )
   {
      repaint();
   } // end method actionPerformed
} // end class SaverJPanel
