/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cube;

// Program draws a cube.
import javax.swing.JFrame;

public class Cube
{
   public static void main( String args[] )
    {
        JFrame frame =new JFrame( "Draw a Cube" );
	  
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	CubeJPanel cubejpanel = new CubeJPanel();
        
	frame.add(cubejpanel); // add panel to frame
        frame.setSize(250, 270);
        frame.setVisible( true );
    } // end main
} // end class Cube
