/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llist2;

/**
 *
 * @author Chris
 */
public class LList2Test {
    
    public static void main(String[] args) {
	testList();
    }

    
    public static void testList() {
      LList2<String> runnerList1 = new LList2<String>();
      LList2<String> runnerList2 = new LList2<String>();

      runnerList1.add("16");
      runnerList1.add("4");
      runnerList1.add("33");
      runnerList1.add("27");
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
      
      boolean contains2 = runnerList1.contains2("33");
      System.out.println(contains2);
    } 
}
