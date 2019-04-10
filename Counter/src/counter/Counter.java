/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter;

/**
 *
 * @author Chris
 */
public class Counter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int counter = 0;
        int q = 5;
        switch(q)
        {
        case 1:
            System.out.println(1);
        case 2:
            System.out.println(2);
        case 3:
            System.out.println(3);
        case 4:
            System.out.println(4);
        case 5:
            System.out.println(5);
        ddefault:
            System.out.println("default");

        }
    }
}
