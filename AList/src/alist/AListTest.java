/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alist;

/**
 *
 * @author Chris
 */
public class AListTest {
    
    public static void main(String[] args) {
	testList();
    }

    
    public static void testList() {
      AList<String> runnerList1 = new AList<String>();
      AList<String> runnerList2 = new AList<String>();

      runnerList1.add("16");
      runnerList1.add("4");
      runnerList1.add("33");
      runnerList1.add("27");
      runnerList1.add("27");
      
      runnerList2.add("16");
      runnerList2.add("4");
      runnerList2.add("33");
      runnerList2.add("27");
      runnerList2.add("27");
      
      int index = runnerList1.getLastIndex("4");
      System.out.println(index);
      
      boolean equal = runnerList1.equals(runnerList2);
      System.out.println(equal);
      
      int repeats = runnerList1.removeEvery("27");
      System.out.println(repeats);
    } 
}
