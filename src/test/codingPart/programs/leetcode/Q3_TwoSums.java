package test.codingPart.programs.leetcode;

import org.testng.annotations.Test;

import java.util.*;

public class Q3_TwoSums {

    @Test
    public void twoSum() {
        int[] arr = {0, 2, 3, 5, 6, 7, 8, 9};
        int target = 12;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == target) {
                    System.out.println(arr[i] + " and " + arr[j]);
                }
            }
        }
    }


    @Test
    public void twoSum1() {
        int[] arr = {2, 3, 5, 6, 7, 8, 9};
        int target = 12;
        Map<Integer, Integer> hashMap = new HashMap();

        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
            //System.out.println(hashMap.get(arr[i]));
        }


        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];//12-2
            if (hashMap.containsKey(diff) && hashMap.get(diff) != i) {
                System.out.println(arr[i] + " and " + diff);
            }
        }
    }














}
