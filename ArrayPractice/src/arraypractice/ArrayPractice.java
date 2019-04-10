/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraypractice;

/**
 *
 * @author Chris
 */
public class ArrayPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] array1 = { 87, 68, 94, 100, 5, 83, 78, 85, 91, 76, 87 };
        
        int f = 5;
        
        int[] g = {8,8,8,8,8};
        
        int[] c = new int[100];
        int cSum = 0;
        
        for (int value: array1) {
            if (value == f) {
                value = 0;
            }
        }
        
        for (int i = 0; i < array1.length; i++) {
            System.out.printf("%d\n", array1[i]);
        }
        int a[]={10,20,30,40,50};
        int b[]=new int[a.length];
        
        float[] arrayFloat = {8.30f, 2.20f};
        
        //copying one array to another
        for(int i=0;i<a.length;++i){
            b[i]=a[i];
        }
        
        //printing array
        for(int i=0;i<b.length;++i){
            System.out.print(b[i]+" ");
        }
        
        // Random randomNumbers = new Random();
        // ++frequency[ 1 + randomNumbers.nextInt( 6 ) ];
    }
}
