/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabularoutput;

/**
 *
 * @author Chris
 */
public class TabularOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("N\t10*N\t100*N\t1000*N\n");
        
        for (int i =1; i < 6; i++) {
            System.out.printf("%d.\t%d\t%d\t%d\n", i, (i*10), (i*100), (i*1000));
        }
    }  
}
