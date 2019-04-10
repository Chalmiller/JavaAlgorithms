/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortarray;
import java.util.*;
import java.util.Arrays;
/**
 *
 * @author Chris
 */
public class Interval {
    
    public <T extends Comparable<? super T>> int getUpper(T [] arr, List<T> targetValues) {
        int max_idx = 0;
        // getUpper()
        for (int index = 0; index < targetValues.size(); index++) {
            T target = targetValues.get(index);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].compareTo(target) >= 0 && j == arr.length - 1) {
                    max_idx = j;
                } else if (arr[j].compareTo(target) >= 0){
                    max_idx = j;
                }
            }
        }
        return max_idx;
    }
    
    public <T extends Comparable<? super T>> int getLower(T [] arr, List<T> targetValues) {
        int min_idx = 0;
        // getLower()
        for (int index = 0; index < targetValues.size(); index++) {
            T target = targetValues.get(index);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].compareTo(target) < 0 && j == 0) {
                    min_idx = -1;
                } else if (arr[j].compareTo(target) < 0){
                    min_idx = j;
                }
            }
        }
        return min_idx;
    }
}
